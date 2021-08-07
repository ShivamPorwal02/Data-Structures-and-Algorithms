package LeetCode;

public class PushDominoes {
    public String pushDominoes(String str) {
        char[] arr = new char[str.length()+2];

        arr[0] = 'L';
        arr[arr.length-1] = 'R';

        for(int i=1;i<arr.length-1;i++){
            arr[i] = str.charAt(i-1);
        }

        int i=0;
        int j =1;


        while(j!=arr.length){
            while(arr[j]=='.') j++;

            if(arr[i]=='L' && arr[j]=='L'){
                while(i!=j){
                    arr[i] = 'L';
                    i++;
                }
                j++;
            }else if(arr[i]=='L' && arr[j]=='R'){
                i=j;
                j++;
            }else if(arr[i]=='R' && arr[j]=='L'){
                int temp1 = i+1;
                int temp2 = j-1;

                while(temp1<temp2){
                    arr[temp1] = 'R';
                    arr[temp2] = 'L';
                    temp1++;
                    temp2--;
                }
                i=j;
                j++;
            }else if(arr[i]=='R' && arr[j]=='R'){
                while(i!=j){
                    arr[i] = 'R';
                    i++;
                }
                j++;
            }
        }

        StringBuilder s = new StringBuilder();
        for(i=1;i<arr.length-1;i++){
            s.append(arr[i]);
        }
        return s.toString();
    }
}
