package day1.day1.string;

public class SortBoom {
    public static void main(String[] args) {
//        String arriveTime = "12:34:56";
//        String departureTime = "14:36:22";
        String arriveTime = "20:00:00";
        String departureTime = "04:00:00";

        int arriveTimeSec = getSec(arriveTime);
        int departureTimeSec = getSec(departureTime);

        String diff = getDiffTime(arriveTimeSec, departureTimeSec);

        System.out.println(diff);
    }

    private static String getDiffTime(int arriveTimeSec, int departureTimeSec) {
        String answer = "";
        int oneHour = (60 * 60);

        int te1 = arriveTimeSec;
        int te2 = departureTimeSec;
        int diffInMillies = Math.abs(departureTimeSec - arriveTimeSec);

        int hour = diffInMillies / oneHour;
        int minute = diffInMillies / (hour * oneHour);
        int second = diffInMillies - (hour * oneHour) - minute * 60;
        answer = getZeroTime(hour) + ":" + getZeroTime(minute) + ":" + getZeroTime(second);
        return answer;
    }

    private static String getZeroTime(int time) {
        if(time < 10) {
            return "0" + time;
        } else {
            return "" + time;
        }
    }


    private static int getSec(String time) {
        String[] timeArr = time.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1]);
        int second = Integer.parseInt(timeArr[2]);
        return (hour * 60 * 60) + (minute * 60) + second;
    }
}
