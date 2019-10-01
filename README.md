# tanker-optimization

Prerequiste
=
`>=Java1.8`
`Maven`

How to Run
=
`mvn clean install`
Main is Starter.java 

Summary - Load your tankers with oil

. Description - A shipping company is providing oil delivery between two continents using

tankers. They’re trying to increase their efficiency by keeping their ships in port to wait

for additional oil to prevent setting to sea only partially loaded.

 

 

As a logistician, the challenge for you will be to determine all variations of efficient

delivery based on the available tankers and the total amount of oil in barrels needed to

achieve maximum efficiency.

 

A tanker's carrying capacity is expressed in barrels of oil that it can take on board.

 

E.g. Some company has only two kind of tankers with the capacity of 2 and 5 barrels

and the amount of oil to be transferred is 12 barrels. In this case there are two options of

efficient delivery:

 

1. load 6 tankers with the capacity of 2. [6,0]

 

2. load 1 tanker with the capacity of 2 and 2 tankers with the capacity of 5. [1,2]

 

If this company had three kind of tankers with the capacity of 6, 7, 8 barrels and 10

barrels of oil to be transferred then there would be no option for efficient delivery and the

minimum amount of oil needed would be 12 [6,0,0] so the answer in this case is 2.

 

So you see that if there is no option to load the tankers effectively, you need to find out

the minimum amount of oil which needs to be added to the given quantity to make the

efficient delivery possible.

 

. Input - Your program should read lines from standard input. Each line contains rows with

available tankers in brackets in sorted order, and the amount of oil after a comma. 
