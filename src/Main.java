public class Main {
    public static void main(String[] args) {
        IBuild builder = new ForwardingProfileBuilder();
        System.out.println(builder
                .setForwardingPolicy(1,false, new String[]{"19725551234", "19725551235"})
                    .setFwdDetails("19725559876", "busy","2018-01-01", "2018-06-30", true)
                        .setRoutine("Wednesday","09:00:00", "17:30:00")
                        .setRoutine("Friday","17:00:00", "18:30:00")
                    .setFwdDetails("19725559876", "unanswered", "2018-01-01","2018-06-30", false)
                        .setRoutine("Sunday","09:00:00", "17:30:00" )
                .setForwardingPolicy(2, false,new String[]{"19725551236"})
                    .setFwdDetails("19725559877", "unreachable", "2018-01-01","2018-06-30", true)
                        .setRoutine("Saturday","09:00:00", "17:30:00")
                .setForwardingPolicy(3, true,null)
                    .setFwdDetails("19725559877", "always", "2018-01-01","2018-06-30", true)
                        .setRoutine("Sunday","22:00:00", "00:00:00")
                        .setRoutine("Monday","00:00:01", "06:00:00")
                .build());
    }
}