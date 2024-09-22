package day2;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution1 {

  static class Product {
    String productId;
    int totalPurchases;
    int uniqueCustomers;
    int repurchaseCustomers;

    public Product(String productId) {
      this.productId = productId;
      this.totalPurchases = 0;
      this.uniqueCustomers = 0;
      this.repurchaseCustomers = 0;
    }

    public double getRepurchaseRate() {
      if (uniqueCustomers == 0) return 0.0;
      return (repurchaseCustomers / (double) uniqueCustomers) * 100;
    }
  }

  public static List<String> solution(String[] records, int k, String date) throws ParseException {
    // 날짜 처리용 SimpleDateFormat
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date referenceDate = sdf.parse(date);

    // 기준 날짜에서 k일 전까지의 기간
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(referenceDate);
    calendar.add(Calendar.DAY_OF_MONTH, -k + 1);
    Date startDate = calendar.getTime();

    // 상품별 구매 기록을 저장할 맵
    Map<String, Product> productMap = new HashMap<>();
    Map<String, Set<String>> customerMap = new HashMap<>();

    // 기록 순회
    for (String record : records) {
      String[] parts = record.split(" ");
      Date recordDate = sdf.parse(parts[0]);
      String userId = parts[1];
      String productId = parts[2];

      // 주어진 기간에 속하지 않는 경우 무시
      if (recordDate.before(startDate) || recordDate.after(referenceDate)) {
        continue;
      }

      // 상품별 정보 업데이트
      productMap.putIfAbsent(productId, new Product(productId));
      Product product = productMap.get(productId);
      product.totalPurchases++;

      // 사용자별 구매 기록 관리
      customerMap.putIfAbsent(productId, new HashSet<>());
      Set<String> customers = customerMap.get(productId);

      if (!customers.contains(userId)) {
        customers.add(userId);
        product.uniqueCustomers++;
      } else {
        product.repurchaseCustomers++;
      }
    }

    // 결과 리스트 생성
    List<Product> productList = new ArrayList<>(productMap.values());

    // 정렬 기준: 재구매율 -> 총 구매 횟수 -> 상품 ID
    productList.sort((a, b) -> {
      if (Double.compare(b.getRepurchaseRate(), a.getRepurchaseRate()) != 0) {
        return Double.compare(b.getRepurchaseRate(), a.getRepurchaseRate());
      }
      if (b.totalPurchases != a.totalPurchases) {
        return b.totalPurchases - a.totalPurchases;
      }
      return a.productId.compareTo(b.productId);
    });

    // 상품 아이디만 결과로 변환
    List<String> result = new ArrayList<>();
    for (Product p : productList) {
      if (p.uniqueCustomers > 0) {
        result.add(p.productId);
      }
    }

    // 결과가 없는 경우 "no result" 추가
    if (result.isEmpty()) {
      result.add("no result");
    }

    return result;
  }

  public static void main(String[] args) throws ParseException {
    String[] records1 = {
        "2020-02-02 uid141 pid141",
        "2020-02-03 uid141 pid32",
        "2020-02-04 uid32 pid32",
        "2020-02-05 uid32 pid141"
    };
    System.out.println(solution(records1, 10, "2020-02-05")); // ["pid32", "pid141"]

    String[] records2 = {
        "2020-01-01 uid1000 pid5000"
    };
    System.out.println(solution(records2, 10, "2020-01-11")); // ["no result"]

    String[] records3 = {
        "2020-02-02 uid1 pid1", "2020-02-26 uid1 pid1", "2020-02-26 uid2 pid1",
        "2020-02-27 uid3 pid2", "2020-02-28 uid4 pid2", "2020-02-29 uid3 pid3",
        "2020-03-01 uid4 pid3", "2020-03-03 uid1 pid1", "2020-03-04 uid2 pid1",
        "2020-03-05 uid3 pid2", "2020-03-05 uid3 pid3", "2020-03-05 uid3 pid3",
        "2020-03-06 uid1 pid4"
    };
    System.out.println(solution(records3, 10, "2020-03-05")); // ["pid1", "pid3", "pid2"]
  }
}
