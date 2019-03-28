Alex Richardson & Joshua Patterson
February 13, 2019
CMSI 387
Prof. Johnson
Detailed Design
### 2.1 – Detailed list of Linux modules that will be modified/affected
The main objective of our project is to allow the set-time module on the Linux kernal to be able to read and display both 12hr and 24hr clock formats. We will do this by modifying the following command:
```
# timedatectl set-time
 ```
 As of now, the kernal only displays a 24hr format only . By modifying this command to allow inputs such as :
 
 ```
 # timedatectl set-time 12hr
 ```
 and
 
 ```
 # timedatectl set-time 24hr
 ```
 The module will be able to distinguish between 12hr and 24hr when outputting the proper time/date.
 
### 2.2 - Detailed list of any new modules that you will produce [or 'Not Applicable' if there are none]
### 2.3 – Class diagram showing affected modules [and any new modules] and how they related to one another
### 2.4 – List or table of explanations of all command line options that will be implemented

Alex Richardson & Joshua Patterson
February 13, 2019
CMSI 387
Prof. Johnson
Preliminary Design
### 1.2 – Rationale as to why this is a good idea, or what the good points of it are

At first glance a 12 hour clock is easier to read for a majority of users. Linux should be able to accomodate for both forms rather than just a 24 hour clock. In addition to this, there should be an option for the user to choose which form is more comfortable for them. The user should be able to enter what time and date is proper without having the hassle of prompting help for syntax. Input formats for this module also vary if its just a time, just a date, or time and date. These variations revolve around hyphens and apostrophes, making the syntax for each command confusing. We want to have a static format with many options to increase the usability of this module.

### 1.3 – Preliminary list of [possible] Linux modules that will be modified/affected
```
# timedatectl set-time
```
Only the set-time module would be affected, but several input formats may be modified. 
Example:
```
# timedatectl set-time 15:58:30
```
The current input format doesn't include an "am" or "pm" tag because it is not in the 12 hour clock form. Inputting a 12 hour clock time would allow the additional tag:

``` 
# timedatectl set-time 3:58:30 pm
```

Also, for the current set-time module, the format for only setting the date  does not include hyphen nor apostrophes. While setting the time and date, hyphens and apostrophes are then added:
```
# timedatectl set-time 20151120
```
```
# timedatectl set-time '2015-11-20 16:14:50'
```
We will modify this in several ways:
-to allow the input format:
```
# timedatectl set-time 1 JAN 2019 1:00:00 pm
```
-to elimate the need of apostrophes and always include hyphens in number-formatted dates:
```
# timedatectl set-time 2019-1-1 1:00:00 pm
```

### 1.4 – Preliminary list of any new modules that you will produce [or 'Not Applicable' if there are none]
```
# timedatectl set-time 12hr
13 FEB 2019 4:06:00 pm
```
- Shows the date in 12hr format
```
# timedatectl set-time 24hr
13 FEB 2019 16:06:00
```
- Shows the date in 24hr format without am or pm tag.
```
# timedatectl set-time 2018-6-5 1:00:00 pm
```
- Adding "am" or "pm" in the string allows the clock to change in reference to the 12 hour clock
