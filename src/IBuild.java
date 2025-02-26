public interface IBuild {
    String build();
    IBuild setForwardingPolicy(int policyId, boolean isApplicableForTuid, String[] inputLines);
    IBuild setFwdDetails(String fwdNumber, String condition, String startDate, String endDate, boolean enabled);
    IBuild setRoutine(String day, String startTime, String endTime);
}
