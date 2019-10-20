### **How to run**

It's a Java console application that can be run as executable jar 
or from IDE of your choice. The entry point is in Main.java. 

When you start the app you would be asked to enter an integer number 
representing how many purchases you want to input. Then you would be asked
to enter sequentially the type of the card (b for bronze, s for silver and
g for gold, only small letters are excepted), the turnover of the card
for the previous month (only positive numbers >= 0) and the purchase value
(only positive numbers) for each purchase.
 
**Sample input**
<pre>
b
0
150</pre>
 
**Sample output**
<pre>
Purchase value: $150.00
Discount rate: 0.0%
Discount: $0.00
Total: $150.00</pre>

**Sample input 2**
<pre>
s
600
850</pre>
 
**Sample output 2**
<pre>
Purchase value: $850.00
Discount rate: 3.5%
Discount: $29.75
Total: $820.25</pre>
 
**Sample input 3**
<pre>
g
1500
1300</pre>
 
**Sample output 3**
<pre>
Purchase value: $1300.00
Discount rate: 10.0%
Discount: $130.00
Total: $1170.00</pre>
 
### **Description**
 
 I used an abstract class `Card` to hold the main card properties and 
 decelerate an abstract method calculating the current discount which 
 is being overridden in the child classes `BronzeCard`, `SilverCard` and `GoldCard`.
 
 
 There is also `PayDesk` class which contains the static methods for 
 calculation of the needed output information. 
 