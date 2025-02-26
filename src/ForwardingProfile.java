/**
 * Call Forwarding API at *****
 */
public class ForwardingProfile {
    public ForwardingPolicy[] forwardingPolicy;

    public class ForwardingPolicy {
        public String[] allowedNumbersForwarding;
        public int policyId;
        public FwdDetails[] fwdDetails;
        public boolean isApplicableForAll;

        public class FwdDetails {
            public String fwdNumber;
            public String condition;
            public Routine[] routine;
            public String endDate;
            public String startDate;
            public boolean enabled;

            public class Routine {
                public String startTime;
                public String endTime;
                public String day;
            }
        }
    }
}
