# code-assessment

### System Requirements
* JDK: 1.8 (1.8.0_40)
* Gradle: 2.7

### General Assumptions
* the input json file/dataset is assumed to be valid and complete (no invalid or missing fields/values)
* all sorting criteria are assumed to be requested with the same probability (so no one of them has been assumed to be the default, and used to store the hotels list)
* no information is available about the usage of the "library" (single/multi-threaded environment), and as a consequence:
 * no caching of the values computed for sorting has been implemented (distances, min rates, avg ratings)
 * the sorting doesn't modify the actual location object, but rather returns a brand new list of hotels
 * streams have been implemented as ordinary ones, but should be converted to parallel ones for multithread applications

