Alex Richardson & Joshua Patterson
February 13, 2019
CMSI 387
Prof. Johnson
Preliminary Design
### 1.1 – Description of modification/addition to Linux
```
$ timedatectl set-time
 ```
  - Will now allow inputs in 12 hour clock form with an addition of "am or pm" . There will be an option to choose between 24hr clock format and 12hr clock format.
  
### 1.2 – Rationale as to why this is a good idea, or what the good points of it are

At first glance a 12 hour clock is easier to read for a majority of users. Linux should be able to accomodate for both forms rather than just a 24 hour clock. In addition to this, there should be an option for the user to choose which form is more comfortable for them.

### 1.3 – Preliminary list of [possible] Linux modules that will be modified/affected
```
$ timedatectl set-time
```

### 1.4 – Preliminary list of any new modules that you will produce [or 'Not Applicable' if there are none]
```
$ timedatectl set-time 12hr
13 FEB 2019 4:06:00 pm
```
- Shows the date in 12hr format
```
$ timedatectl set-time "2018-6-5 1:00:00 pm"
8 JUN 2018 1:00:00 pm
```
- Adding "am" or "pm" in the string allows the clock to change in reference to the 12 hour clock
