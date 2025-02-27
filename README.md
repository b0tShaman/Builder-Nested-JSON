# Builder Pattern for Nested JSON

This project implements the Builder Pattern to construct complex nested JSON structures for forwarding policies. It provides an easy-to-use, fluent API to define policies, conditions, forwarding details, and routines.

## Features
- Uses the **Builder Pattern** to simplify the creation of complex JSON objects.
- Leverages **Gson** for JSON serialization.

## Example JSON Output
This builder generates a structured JSON output like:
```json
{
  "forwardingPolicy": [
    {
      "allowedNumbersForwarding": ["19725551234", "19725551235"],
      "policyId": 1,
      "fwdDetails": [
        {
          "fwdNumber": "19725559876",
          "condition": "busy",
          "routine": [
            { "startTime": "09:00:00", "endTime": "17:30:00", "day": "Wednesday" },
            { "startTime": "17:00:00", "endTime": "18:30:00", "day": "Friday" }
          ],
          "endDate": "2018-06-30",
          "startDate": "2018-01-01",
          "enabled": true
        }
      ],
      "isApplicableForAll": false
    }
  ]
}
```

## Usage
### Builder Example
```java
IBuild builder = new ForwardingProfileBuilder();
System.out.println(builder
    .setForwardingPolicy(1, false, new String[]{"19725551234", "19725551235"})
        .setFwdDetails("19725559876", "busy", "2018-01-01", "2018-06-30", true)
            .setRoutine("Wednesday", "09:00:00", "17:30:00")
            .setRoutine("Friday", "17:00:00", "18:30:00")
    .build());
```

## Project Structure
```
Builder-Nested-JSON
│── lib
│   └── gson-2.10.1.jar
│── src
│   ├── ForwardingProfile.java
│   ├── ForwardingProfileBuilder.java
│   ├── IBuild.java
│   ├── Main.java
```

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone https://github.com/b0tShaman/Builder-Nested-JSON.git
   ```
2. Add **Gson** dependency:
   - Go to **File → Project Structure → Modules → Dependencies → Add → JAR**
   - Select `lib/gson-2.10.1.jar`, then click **Apply** and **OK**
3. Run `Main.java`

## Dependencies
- [Gson 2.10.1](https://github.com/google/gson)

