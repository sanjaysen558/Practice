public class Main {
    public static void main(String[] args) {
        Main m =  new Main();
        main();
    }
    public static void main(){
        String word;
        StringBuffer tempStr= new StringBuffer();
        int pos = 0;
        char character;
        String t1 = "%^i2 1%hello 4-sanjay 021am>"; //hello i am sanjay
        String t2 = "";
        String t1Arr[] = t1.split(" ");
        String t2Arr[] = new String[t1Arr.length];

        for (String str:t1Arr) {
            word = str.replaceAll("[^a-zA-Z0-9]","");
            for(int i=0;i<word.length();i++){
                character = word.charAt(i);
                if(Character.isDigit(character)){
                    pos=pos+Integer.parseInt(String.valueOf(character));
                }else{
                    if(tempStr==null)
                        tempStr = new StringBuffer(String.valueOf(character));
                    else
                        tempStr.append(character);
                }
            }
            t2Arr[pos-1] = String.valueOf(tempStr);
            pos = 0;
            tempStr=null;
        }
        System.out.println(t1);
        System.out.println("Resolved:");
        for (String str:t2Arr) {
            t2 = t2+str+" ";
        }
        System.out.println(t2);
    }
}