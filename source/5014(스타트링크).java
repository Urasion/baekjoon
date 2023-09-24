class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(int i=0; i<babbling.length; i++){
            int count = 0;
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")){
                continue;
            }
            babbling[i].replace("aya", " ").replace("ye", " ").replace("ma", " ").replace("woo", " ").replace(" ","");
            if(babbling[i].isEmpty()){
                answer += 1;
            }


        }
        return answer;
    }

}
