package day1.lguPlus;

import java.util.HashMap;
import java.util.Map;

public class DateSales {
    public static void main(String[] args) {
        String[] recodes = {
                "2020-02-02 uid1 pid1", "2020-02-26 uid1 pid1", "2020-02-26 uid2 pid1", "2020-02-27 uid3 pid2", "2020-02-28 uid4 pid2", "2020-02-29 uid3 pid3", "2020-03-01 uid4 pid3", "2020-03-03 uid1 pid1", "2020-03-04 uid2 pid1", "2020-03-05 uid3 pid2", "2020-03-05 uid3 pid3", "2020-03-05 uid3 pid3", "2020-03-06 uid1 pid4"
//                "2020-01-01 uid1000 pid5000"
        };
        int k = 10;
        String date = "2020-01-11";
        new DateSales().solution(recodes, k, date);
    }

    public String[] solution(String[] records, int k, String date) {
        String[] answer = {};
        int dateRangeUp = getDate(date, k);
        int dateRangeDown = getDate(date, -k);
        Map<String, Integer> dateMap = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            int dateRange = getDate(record[0], 0);
            if(dateRange <= dateRangeUp && dateRange >= dateRangeDown) {
                dateMap.put(record[2], dateMap.getOrDefault(record[2], 0) + 1);
            }
        }
        answer = dateMap.keySet().stream().filter(key -> dateMap.get(key) > 1).toArray(String[]::new);
        if(answer.length == 0) {
            return new String[] {"no result"};
        }
        return answer;
    }

    public int getDate(String date, int k) {
        String[] dateArr = date.split("-");
        int dateInt = Integer.parseInt(dateArr[2]) * 60 * 24;
        int month = Integer.parseInt(dateArr[1]);
        int year = Integer.parseInt(dateArr[0]);
        if(dateInt + k > 30) {
            month++;
            dateInt = dateInt + k % 30;
        }
        if(month > 12) {
            year++;
            month = month % 12;
        }

        int yearInt = year * 60 * 24 * 30 * 365;
        int monthInt = month * 60 * 24 * 30;
        return yearInt + monthInt + dateInt + (k * 60 * 24);

    }
}
