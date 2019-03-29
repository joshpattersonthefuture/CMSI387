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
Rather than completely new modules, we decided to continue modifying the set-time module to also allow proper date inputs for 12hr and 24hr clock formats, such as adding an "am" or "pm" tag to inputs and outputs, and by creating a static format for setting the date.

Currently, to set the date and time using the set-time module, the inputs must be in one of the two formats:
```
# timedatectl set-time 20151120
```
```
# timedatectl set-time '2015-11-20 16:14:50'
```
Either by inputting the Date in a "YEAR MONTH DATE" format without hypens or by inputting a "YEAR MONTH DATE" format with hypens, followed by a 24hr format of the current time, all wrapped by apostrophes. 

We will modify this to create a simple and universal way of inputting and outputting the respected date/time.
The formats we will use are the following :
```
# timedatectl set-time 1 JAN 2019 1:00:00 pm
```

An Alphabetical format for date and time without apostrophes. The "am" or "pm" tag will allow the module to distinguish between 12hr and 24hr clock formats when setting the date.


Outputs for setting the time will be the following: 

```
# timedatectl set-time 12hr
13 FEB 2019 4:06:00 pm
```
```
# timedatectl set-time 24hr
13 FEB 2019 16:06:00
```


### 2.3 – Class diagram showing affected modules [and any new modules] and how they related to one another
### 2.4 – List or table of explanations of all command line options that will be implemented

New options for both 12 and 24 hours allows the user to quickly view the time in either 12hr or 24hr format. The user by default is shown the time in 24hr format, making `--12hr` the only useful option. If the user changes their default to 12hr format then `--24hr` becomes the way to quickly see the time in 24hr format.

| New Options   | Example   | Function        
| ------------- |:----------|:-------------:|
| `--12hr` | `# timedatectl --12hr` | shows time output in 12hr format
| `--24hr` | `# timedatectl --24hr` | shows time output in 24hr format

The command that needs to be modified alters the way in which the user sets the time and date of the operating system. The user can now change the time with am/pm or leave off am/pm altogether to input the time in 24hr format. This allows for the user to adjust the time quicker since the user is likely referencing a clock with 12hr time in making the adjustment to the operating system. We also changed the way the month is inputted from a digit format `03` to an abbreviated version of the month's name in English `MAR`. We made that decision when we noticed a discrepancy in the way the console outputted date/time vs. the way the user inputted a new date/time. The console outputted a 3 letter abbreviation whereas the `timedatectl` required a 2 digit version of the month.

| Modified Commands | Example     | Format       | Function
| ----------------  |:------------|:------------:|:------------:|
| `set-time`       | `# timedatectl set-time 01 JAN 2019 1:00:00 pm`| `# timedatectl set-time dd MMM yyyy hh:mm:ss pm/am` | sets the date/time in accordance to a 12hr clock
