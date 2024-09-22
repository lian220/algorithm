package day2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution2 {

  static class Product {
    String productId;
    int totalPurchases;
    Set<String> uniqueCustomers = new HashSet<>();
    Set<String> repurchaseCustomers = new HashSet<>();

    public Product(String productId) {
      this.productId = productId;
    }

    public void addPurchase(String userId) {
      totalPurchases++;
      if (uniqueCustomers.contains(userId)) {
        repurchaseCustomers.add(userId);
      } else {
        uniqueCustomers.add(userId);
      }
    }

    public double getRepurchaseRate() {
      if (uniqueCustomers.size() == 0) return 0.0;
      return (repurchaseCustomers.size() / (double) uniqueCustomers.size()) * 100;
    }
  }

  public static List<String> solution(String[] records, int k, String date) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date referenceDate = sdf.parse(date);

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(referenceDate);
    calendar.add(Calendar.DAY_OF_MONTH, -k + 1);
    Date startDate = calendar.getTime();

    Map<String, Product> productMap = new HashMap<>();

    //record 가 해당 날짜에 속하는지 확인하고, 속하지 않는다면 continue
    for (String record : records) {
      String[] parts = record.split(" ");
      Date recordDate = sdf.parse(parts[0]);
      String userId = parts[1];
      String productId = parts[2];

      if (recordDate.before(startDate) || recordDate.after(referenceDate)) {
        continue;
      }

      // 해당 상품이 없다면 새로 생성
      productMap.putIfAbsent(productId, new Product(productId));
      Product product = productMap.get(productId);
      product.addPurchase(userId);
    }

    List<Product> productList = new ArrayList<>(productMap.values());

    // 정렬
    productList.sort((a, b) -> {
      int compareRate = Double.compare(b.getRepurchaseRate(), a.getRepurchaseRate());
      if (compareRate != 0) {
        return compareRate;
      } else if (b.totalPurchases != a.totalPurchases) {
        return b.totalPurchases - a.totalPurchases;
      } else {
        return b.productId.compareTo(a.productId); // 상품 ID 내림차순 정렬
      }
    });

    List<String> result = new ArrayList<>();
    for (Product p : productList) {
      if (p.uniqueCustomers.size() > 0) {
        result.add(p.productId);
      }
    }

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


