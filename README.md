# code-assessment

### Environment Requirements
* JDK: 1.8 (1.8.0_40)
* Gradle: 2.7

### General Assumptions
* the input json file/dataset is assumed to be valid and complete (no invalid or missing fields/values)
* all sorting criteria are assumed to be requested with the same probability (so no one of them has been assumed to be the default, and used to store the hotels list)
* if 2 hotels are equivalent according to the primary sorting criteria selected, the hotel name is used as secondary sorting criteria
* no information is available about the usage of the "library" (single/multi-threaded environment), and as a consequence:
 * no caching of the values computed for sorting has been implemented in the domain objects (distances, min rates, avg ratings)
 * the sorting doesn't modify the actual location object, but rather returns a brand new list of hotels
 * streams have been implemented as ordinary ones, but should be converted to parallel ones for multithread applications

### Run instructions
From the project folder run `gradle run -PappArgs="['<sorting_criteria>', '<sorting_direction>']"`

Available sorting criteria  are:
* distance
* price
* rating
 
Available sorting directions are:
* ascending
* descending

e.g.: `gradle run -PappArgs="['price', 'descending']"`
 
### Available Gradle Tasks:
 *  `clean` - delete all build artifacts
 *  `test` - run all unit tests (reports -> 'build/reports/tests/', results -> 'build/test-results/')
 *  `intTest` - run integration tests (reports -> 'build/reports/tests/', results -> 'build/test-results/')
 *  `generateJavadocs` - generate javadoc documentation into 'build/docs/javadoc/'
 *  `build` - build application
 *  `run` - run main method, expects sorting criteria and direction parameters: e.g. `-PappArgs="['rating', 'descending']"`

