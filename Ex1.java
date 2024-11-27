public class Ex1
{
    /* Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num)
    {
        int ans = -1;
        int sum=0;
        int baseAsInt;
        int ActualLengthofNumber=num.length()-2;
        char base=num.charAt(num.length()-1);
        int tempAsInt, tempForBaseInPower;
        if(isNumber(num)==false)
            return -1;
        if(base>='2'&&base<='9'||base=='A')
        {
            if(base=='A')
                baseAsInt=10;
            else
                baseAsInt=base-'0';
            for (int i = ActualLengthofNumber-1, j = 0; i >= 0; i--, j++)
            {
                tempAsInt=num.charAt(i)-'0';
                tempForBaseInPower=(int)Math.pow(baseAsInt, j);
                sum=sum+tempAsInt*tempForBaseInPower;
            }
        }
        else
        {
            baseAsInt=baseFromCharacter(base);
            for (int i = ActualLengthofNumber-1, j = 0; i >= 0; i--, j++)
            {
                if(num.charAt(i)>='1'&&num.charAt(i)<='9')
                {
                    tempAsInt=num.charAt(i)-'0';
                }
                else
                {
                    tempAsInt=baseFromCharacter(num.charAt(i));
                }
                tempForBaseInPower=(int)Math.pow(baseAsInt, j);
                sum=sum+tempAsInt*tempForBaseInPower;
            }
        }


        ans=sum;
        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a)
    {
        boolean ans = true;
        if(a==null)
            ans=false;
        else
            ans=CheckFormatBeforeb(a);
        return ans;
    }
    public static boolean CheckBaseDigitLegality(String s)
    {
        char ch=s.charAt(s.length()-1);
        if(((ch>='2')&&(ch<='9'))||((ch>='A')&&(ch<='G')))
            return true;
        else return false;

    }
    public static boolean StringMinimumLength(String s)
    {
        if(s.length()>=3)
            return true;
        else return false;
    }
    public static boolean CheckFormatAfterb(String s)
    {
        char ch;
        if(StringMinimumLength(s)&&CheckBaseDigitLegality(s))
        {
            ch=s.charAt(s.length()-2);
            if (ch == 'b') return true;
            else return false;
        }
        return false;
    }
    public static boolean IsInRange(char toCheck, char base)
    {
        if(base>='2'&&base<='9')
        {
            if(toCheck>='0'&&toCheck<base)
                return true;
            else return false;
        }
        else if(base>='A'&&base<='G')
        {
            if((toCheck>='0'&&toCheck<base)||(toCheck>='A'&&toCheck<base))
                return true;
            else return false;
        }
        return false;
    }
    public static boolean CheckFormatBeforeb(String s)
    {
        if(CheckFormatAfterb(s)==false)
            return false;
        else
        {
            char base = s.charAt(s.length() - 1);
            char tmp;
            int LengthOfNumber = s.length() - 2;
            for (int i = 0; i < LengthOfNumber; i++) {
                tmp = s.charAt(i);
                if (IsInRange(tmp, base) == false)
                    return false;
            }
            return true;
        }
    }
    public static int baseFromCharacter(char base)
    {
        int baseInt=0;
        switch(base)
        {
            case 'A':
                baseInt=10;
                break;
            case 'B':
                baseInt=11;
                break;
            case 'C':
                baseInt=12;
                break;
            case 'D':
                baseInt=13;
                break;
            case 'E':
                baseInt=14;
                break;
            case 'F':
                baseInt=15;
                break;
            case 'G':
                baseInt=16;
                break;
        }
        return baseInt;
    }
    public static String CharacterFromNumber(int number)
    {
        String baseChar="";
        switch(number)
        {
            case 10:
                baseChar="A";
                break;
            case 11:
                baseChar="B";
                break;
            case 12:
                baseChar="C";
                break;
            case 13:
                baseChar="D";
                break;
            case 14:
                baseChar="E";
                break;
            case 15:
                baseChar="F";
                break;
            case 16:
                baseChar="G";
                break;
        }
        return baseChar;
    }
    public static boolean equals(String n1, String n2)
    {
        boolean ans = true;
        int num1=number2Int(n1);
        int num2=number2Int(n2);
        if (num1!=num2) ans=false;
        return ans;
    }
    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base)
    {
        if(num<0||base<2||base>16)
            return "Illegal Input";
        int tmp=num;
        int counter=0;
        int SingleConverted;
        String ch;
        String ToReturn="";
        while(tmp>0)
        {
            counter++;
            tmp=tmp/base;
        }
        String result;
        tmp=num;
        for(int i=0;i<counter;i++)
        {
            SingleConverted=tmp%base;
            if(SingleConverted>=10)
            {
                ch=CharacterFromNumber(SingleConverted);
                ToReturn=ToReturn.concat(ch);
            }
            else if(SingleConverted<10)
            {
                ToReturn=ToReturn.concat(Integer.toString(SingleConverted));
            }
            tmp=tmp/base;
        }
        String NewToReturn = "";
        char tempCharForReverse;
        for (int i = 0; i < ToReturn.length(); i++)
        {
            tempCharForReverse = ToReturn.charAt(i);
            NewToReturn = tempCharForReverse + NewToReturn;
        }
        NewToReturn=NewToReturn+"b";
        if(base>=10)
        {
            NewToReturn=NewToReturn+CharacterFromNumber(base);
        }
        else
        {
            NewToReturn=NewToReturn+base;
        }
        return NewToReturn;
    }
    public static int maxIndex(String[] arr)
    {

        int ans = 0;
        int max=number2Int(arr[0]);
        int indexOfMax=0;
        for(int i=1;i<arr.length;i++)
        {
            if(number2Int(arr[i])==max)
            {
                return indexOfMax;
            }
            if((number2Int(arr[i]))>max)
            {
                max=number2Int(arr[i]);
                indexOfMax=i;
            }
        }
        ans=indexOfMax;
        return ans;
    }
}
