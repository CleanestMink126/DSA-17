import java.util.ArrayList;
import java.util.List;

public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        char[] clock = new char[hoursInDay];
        List<char[]> ans = new ArrayList<char[]>();
        recurseC(pennies,nickels,dimes,hoursInDay,0,clock,ans);
        for(char[] j : ans){
            for(int i = 0; i < j.length; i++){
                System.out.print(j[i]);
            }
        }
        return ans;
    }
    public static void recurseC(int pennies, int nickels, int dimes, int hoursInDay, int hour, char[] clock, List<char[]> ans){
        for(int i = 0; i < clock.length; i++){
            System.out.print(clock[i]);
        }
        System.out.println(" ");
        if(hoursInDay == 1){
            if(pennies>0){
                clock[hour] = 'p';
                char[] dest = new char[clock.length];
                System.arraycopy( clock, 0, dest, 0, clock.length );
                ans.add(dest);
            }
            if(dimes>0){
                clock[hour] = 'd';
                char[] dest = new char[clock.length];
                System.arraycopy( clock, 0, dest, 0, clock.length );
                ans.add(dest);
            }
            if(nickels>0){
                clock[hour] = 'n';
                char[] dest = new char[clock.length];
                System.arraycopy( clock, 0, dest, 0, clock.length );
                ans.add(dest);
            }

        }
        if(pennies > 0){

            int nH = hour + 1;
            nH = nH % clock.length;
            if(clock[nH] == 0){
                clock[hour] = 'p';
                recurseC(pennies-1, nickels, dimes, hoursInDay-1, nH, clock, ans);
            }
            clock[hour] = 0;
        }
        if(nickels > 0){
            int nH = hour + 5;
            nH = nH % clock.length;
            if(clock[nH] == 0){
                clock[hour] = 'n';
                recurseC(pennies, nickels-1, dimes, hoursInDay-1, nH, clock, ans);

            }
            clock[hour] = 0;

        }
        if(dimes > 0){
            int nH = hour + 10;
            nH = nH % clock.length;
            if(clock[nH] == 0){
                clock[hour] = 'd';
                recurseC(pennies, nickels, dimes-1, hoursInDay-1, nH, clock, ans);
            }
            clock[hour] = 0;
        }
    }
}
