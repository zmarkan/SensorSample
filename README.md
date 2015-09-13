# SensorSample

Sample dump of compass data from device into log. 
When app is in foreground, compass is dumping, when it's not, it's not.

read data using: `adb logcat | grep ">>>>>>>>>>>>>>>"`

Data is in the following format: `timestamp, valueX, valueY, valueZ;`


