public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        while(isBadVersion.isFailingVersion(n)){
            n = n/2;
            if(n%1 == .5){
                n -= .5;
            }
        }
        long upper = n * 1 + 1;
        long lower = n;
        while(upper - lower > 10){
            long temp =  (upper - lower)/2;
            if(temp%1 == .5){
                temp -= .5;
            }
            if(!isBadVersion.isFailingVersion(lower + temp)){
                lower += temp;
            }else{
                upper = lower + temp;
            }
        }
        while(!isBadVersion.isFailingVersion(lower)){
            lower++;
        }
        return lower;
    }
}
