import com.google.gson.Gson;

/**
 * Created by vpunnapuzha on 5/4/2019.
 * BUILDER for the Below "forwardingProfile" JSON
     {
        "forwardingPolicy" : [
            {
                "policyId" : "1",
                "inputLines" : [ "19725551234", "19725551235", "3167" ],
                "isApplicableForTuid" : "true",
                "fwdDetails" : [
                    {
                        "condition" : "busy",
                        "startDate" : "2018-01-01",
                        "endDate" : "2018-06-30",
                        "routine" : [
                            {
                                "day" : "weekdays",
                                "startTime" : "09:00:00",
                                "endTime" : "17:30:00"
                            }
                        ],
                        "ftn" : "19725559876"
                    },
                    {
                        "condition" : "noanswer",
                        "startDate" : "2018-01-01",
                        "endDate" : "2018-06-30",
                        "routine" : [
                            {
                                "day" : "weekdays",
                                "startTime" : "09:00:00",
                                "endTime" : "17:30:00"
                            }
                        ],
                        "ftn" : "19725559876",
                        "enabled" : "false"
                    }
                ]
            },
            {
                "policyId" : "2",
                "inputLines" : [ "19725551236"  ],
                "isApplicableForTuid" : "false",
                "fwdDetails" : [
                    {
                        "condition" : "personalrouting",
                        "startDate" : "2018-01-01",
                        "endDate" : "2018-06-30",
                        "routine" : [
                            {
                                "day" : "weekdays",
                                "startTime" : "09:00:00",
                                "endTime" : "17:30:00"
                            }
                        ],
                        "ftn" : "19725559877",
                        "enabled" : "true"
                    }
                ]
            }
        ]
    }
 */
public class ForwardingProfileBuilder implements IBuild {
    private final ForwardingProfile forwardingProfile;

    public ForwardingProfileBuilder(){
        this.forwardingProfile = new ForwardingProfile();
    }

    @Override
    public String build() {
        return new Gson().toJson(forwardingProfile,ForwardingProfile.class);
    }

    public ForwardingPolicyBuilder setForwardingPolicy(int policyId, boolean isApplicableForTuid, String[] inputLines ){
        ForwardingProfile.ForwardingPolicy[] forwardingPolicies;
        ForwardingPolicyBuilder forwardingPolicyBuilder                     = new ForwardingPolicyBuilder();

        if( forwardingProfile.forwardingPolicy == null) {
            forwardingPolicies = new ForwardingProfile.ForwardingPolicy[forwardingPolicyBuilder.forwardingPolicy.length];
        }
        else {
            forwardingPolicies                                              = new ForwardingProfile.ForwardingPolicy[forwardingProfile.forwardingPolicy.length + 1];
            // Fill forwardingPolicies
            System.arraycopy(forwardingProfile.forwardingPolicy, 0, forwardingPolicies, 0, forwardingProfile.forwardingPolicy.length);
        }
        ForwardingProfile.ForwardingPolicy forwardingPolicy1                = new ForwardingProfile().new ForwardingPolicy();
        forwardingPolicy1.isApplicableForAll                                = isApplicableForTuid;
        forwardingPolicy1.allowedNumbersForwarding                          = inputLines;
        forwardingPolicy1.policyId                                          = policyId;
        forwardingPolicies[forwardingPolicies.length - 1]                   = forwardingPolicy1;
        forwardingPolicyBuilder.forwardingPolicy                            = forwardingPolicies;
        forwardingProfile.forwardingPolicy                                  = forwardingPolicyBuilder.forwardingPolicy;
        return forwardingPolicyBuilder;
    }

    @Override
    public IBuild setFwdDetails(String fwdNumber, String condition, String startDate, String endDate, boolean enabled) {
        return this;
    }

    @Override
    public IBuild setRoutine(String day, String startTime, String endTime) {
        return this;
    }

    public class ForwardingPolicyBuilder implements IBuild {
        private ForwardingProfile.ForwardingPolicy[] forwardingPolicy;

        ForwardingPolicyBuilder(){
            forwardingPolicy            = new ForwardingProfile.ForwardingPolicy[1];
        }

        @Override
        public String build() {
            return new Gson().toJson(forwardingProfile,ForwardingProfile.class);
        }

        @Override
        public IBuild setForwardingPolicy(int policyId, boolean isApplicableForTuid, String[] inputLines) {
            return this;
        }

        @Override
        public FwdDetailsBuilder setFwdDetails(String fwdNumber, String condition, String startDate, String endDate, boolean enabled) {
            ForwardingProfile.ForwardingPolicy.FwdDetails[] fwdDetails;
            FwdDetailsBuilder fwdDetailsBuilder                                     = new FwdDetailsBuilder();
            if( forwardingPolicy[forwardingPolicy.length - 1].fwdDetails == null) {
                fwdDetails                                                          = new ForwardingProfile.ForwardingPolicy.FwdDetails[fwdDetailsBuilder.fwdDetails.length];
            }
            else {
                fwdDetails                                                          = new ForwardingProfile.ForwardingPolicy.FwdDetails[forwardingPolicy[forwardingPolicy.length - 1].fwdDetails.length + 1];
                // Fill fwdDetails
                System.arraycopy(forwardingPolicy[forwardingPolicy.length - 1].fwdDetails, 0, fwdDetails, 0, forwardingPolicy.length);
            }

            ForwardingProfile.ForwardingPolicy.FwdDetails fwdDetail1                = new ForwardingProfile().new ForwardingPolicy().new FwdDetails();
            fwdDetail1.fwdNumber                                                    = fwdNumber;
            fwdDetail1.condition                                                    = condition;
            fwdDetail1.startDate                                                    = startDate;
            fwdDetail1.endDate                                                      = endDate;
            fwdDetail1.enabled                                                      = enabled;
            fwdDetails[fwdDetails.length - 1]                                       = fwdDetail1;
            fwdDetailsBuilder.fwdDetails                                            = fwdDetails;

            forwardingProfile.forwardingPolicy[forwardingPolicy.length-1].fwdDetails= fwdDetailsBuilder.fwdDetails ;
            return fwdDetailsBuilder;
        }

        @Override
        public IBuild setRoutine(String day, String startTime, String endTime) {
            return this;
        }

        public class FwdDetailsBuilder implements IBuild {
            private ForwardingProfile.ForwardingPolicy.FwdDetails[] fwdDetails;

            FwdDetailsBuilder(){
                fwdDetails            = new ForwardingProfile.ForwardingPolicy.FwdDetails[1];
            }

            @Override
            public String build(){
                return new Gson().toJson(forwardingProfile,ForwardingProfile.class);
            }

            @Override
            public ForwardingPolicyBuilder setForwardingPolicy(int policyId, boolean isApplicableForTuid, String[] inputLines ){
                return ForwardingProfileBuilder.this.setForwardingPolicy(policyId, isApplicableForTuid, inputLines);
            }

            @Override
            public FwdDetailsBuilder setFwdDetails(String fwdNumber, String condition, String startDate, String endDate, boolean enabled) {
                return ForwardingPolicyBuilder.this.setFwdDetails(fwdNumber, condition, startDate, endDate, enabled);
            }

            public RoutineBuilder setRoutine(String day, String startTime, String endTime) {
                ForwardingProfile.ForwardingPolicy.FwdDetails.Routine[] routine;
                RoutineBuilder routineBuilder                                           = new RoutineBuilder();
                if ( fwdDetails[fwdDetails.length - 1].routine == null ) {
                    routine                                                             = new ForwardingProfile.ForwardingPolicy.FwdDetails.Routine[routineBuilder.routine.length];
                }
                else {
                    routine                                                             = new ForwardingProfile.ForwardingPolicy.FwdDetails.Routine[fwdDetails[fwdDetails.length - 1].routine.length + 1];
                    // Fill routine
                    System.arraycopy(fwdDetails[fwdDetails.length - 1].routine, 0, routine, 0, fwdDetails.length);
                }
                ForwardingProfile.ForwardingPolicy.FwdDetails.Routine routine1          = new ForwardingProfile().new ForwardingPolicy().new FwdDetails().new Routine();
                routine1.day                                                            = day;
                routine1.startTime                                                      = startTime;
                routine1.endTime                                                        = endTime;
                routine[routine.length - 1]                                             = routine1;
                routineBuilder.routine                                                  = routine;

                forwardingProfile.forwardingPolicy[forwardingPolicy.length-1].fwdDetails[fwdDetails.length-1].routine  = routineBuilder.routine;
                return routineBuilder;
            }

            public class RoutineBuilder implements IBuild {
                private ForwardingProfile.ForwardingPolicy.FwdDetails.Routine[] routine;
                RoutineBuilder(){
                    routine                                                             = new ForwardingProfile.ForwardingPolicy.FwdDetails.Routine[1];
                }

                @Override
                public String build(){
                    return new Gson().toJson(forwardingProfile,ForwardingProfile.class);
                }

                @Override
                public ForwardingPolicyBuilder setForwardingPolicy(int policyId, boolean isApplicableForTuid, String[] inputLines){
                    return ForwardingProfileBuilder.this.setForwardingPolicy(policyId, isApplicableForTuid, inputLines);
                }

                @Override
                public FwdDetailsBuilder setFwdDetails(String fwdNumber, String condition, String startDate, String endDate, boolean enabled) {
                    return FwdDetailsBuilder.this.setFwdDetails(fwdNumber, condition, startDate, endDate, enabled);
                }

                @Override
                public RoutineBuilder setRoutine(String day, String startTime, String endTime) {
                    return FwdDetailsBuilder.this.setRoutine(day, startTime, endTime);
                }
            }
        }
    }
}
