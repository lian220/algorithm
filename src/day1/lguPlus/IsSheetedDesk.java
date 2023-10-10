package day1.lguPlus;

public class IsSheetedDesk {
    public static void main(String[] args) {
//        String[] place = {"POOOO", "OXXOX", "OOXOX", "OOXOX"};
        String[] place = {"OXO", "XPX", "OXO"};
        new IsSheetedDesk().solution(place);
    }


    public int solution(String[] place) {
        int answer = 0;
        int[][] placeArr = new int[place.length][place[0].length()];
        for(int i = 0; i < place.length; i++) {
            for(int j = 0; j < place[i].length(); j++) {
                if(place[i].charAt(j) == 'P') {
                    placeArr[i][j] = 1;
                } else if(place[i].charAt(j) == 'O') {
                    placeArr[i][j] = 0;
                } else {
                    placeArr[i][j] = -1;
                }
            }
        }

        for(int i = 0; i < placeArr.length; i++) {
            for(int j = 0; j < placeArr[i].length; j++) {
                if(placeArr[i][j] != 1) {
                    if(i + 2 < placeArr.length && placeArr[i + 2][j] != 1) {
                        answer++;
                        break;
                    }
                    if(j + 2 < placeArr[i].length && placeArr[i][j + 2] != 1) {
                        answer++;
                        break;
                    }
                    if(i + 2 < placeArr.length && j + 2 < placeArr[i].length && placeArr[i + 2][j + 2] != 1) {
                        if(placeArr[i + 2][j] != 1 || placeArr[i][j + 2] != 1) {
                            answer++;
                            break;
                        }
                    }
                    if(i + 2 < placeArr.length && j - 2 >= 0 && placeArr[i + 2][j - 2] != 1) {
                        if(placeArr[i + 2][j] != 1 || placeArr[i][j - 2] != 1) {
                            answer++;
                            break;
                        }
                    }
                }
            }
        }



        return answer;
    }
}
