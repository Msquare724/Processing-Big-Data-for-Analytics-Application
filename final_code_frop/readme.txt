Dir etl_code:

The ETL code used by Haoliang Tian have three parts. The first part(first_clean) cleans the data for the analysis that counts the borough
The reclean counts the borough and the purpose is to adjust the first cleaning to allow the joining in Hive table.
The third part is the clean_no_borough which does not count the borough, since there are a lot of invalid data record if count borough.

This dir contains code for how we cleaned the dataset respectively. Clean crash is the Hadoop Map-Reduce code used for cleaning NYC and Chicago crash dataset. With this code, we are able to extract column of number of crashes and regions and time by dropping other irrelevant columns. The first cleaning process also drops data with incomplete region information but the second process keep the data and drop all the region col for a better accuracy. 

**************
In data_ingest, since we use fixed dataset from NYC open data, so what we need is only scp and put them in hdfs.


**************
Dir ann_code:

The ana_code includes the analytical command and code. The Hive_analysis includes the analysis using Hive like correlation, avg values. 
The three txt starting with Hive_table are the commands used to create tables. The scala_regression_correlation txt are the commands to do the regression and correlation analysis.

This Dir contains our analysis of the data.
extrem value: using Map-Reduce to output the min and max temp of the dataset
MeanForCrash: using the result from extrem value to exhibit the corresponding crash number to do a comparison. 


************
The test_code include the chicago folder which is the cleaning code of chicago dataset. We decide to not use this dataset finally, so it is not that useful.


************
Visualization Jupiter file conclude the code for data visualization and plotting of our analysis 
