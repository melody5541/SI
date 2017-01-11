# SI

requirement:
good 
6:15:50 PM: Frank H F WU/HTSA/HSBC: can you modify the case like this 
6:16:19 PM: Frank H F WU/HTSA/HSBC: similar as currently....

instead of the message be put automatically. 
6:16:42 PM: Frank H F WU/HTSA/HSBC: you create a method read the system.in ( so there is a prompt in console ) 
6:16:56 PM: Frank H F WU/HTSA/HSBC: and suppose i enter a value and press "enter" 
6:17:01 PM: Frank H F WU/HTSA/HSBC: the message put in the db 
6:17:06 PM: Allen M ZHANG/HSDC/HSBC: okay i got it. 
6:17:14 PM: Frank H F WU/HTSA/HSBC: and your poller grep the message 
6:17:52 PM: Allen M ZHANG/HSDC/HSBC: console input-->store in db-->poller get the latest msg in message_table 
6:17:54 PM: Allen M ZHANG/HSDC/HSBC: right? 
6:19:43 PM: Frank H F WU/HTSA/HSBC: "poller get the msg in message_table".. not latest.. should be first come first serve 
6:19:57 PM: Frank H F WU/HTSA/HSBC: i think your currently demo is valid 
6:20:29 PM: Allen M ZHANG/HSDC/HSBC: okay got it 
6:21:12 PM: Frank H F WU/HTSA/HSBC: i think do a rename
SpringIntegrationJdbcInboundRowMapperExample <-- SiJdbcInboundAutoOneByOne

and the new one called

SiJdbcInboundManualInput 
6:21:32 PM: Allen M ZHANG/HSDC/HSBC: okay 
6:21:35 PM: Frank H F WU/HTSA/HSBC: i think we need serveral test case to valid the implementation 
6:22:31 PM: Frank H F WU/HTSA/HSBC: SiJdbcInboundAutoOneByOne <-- the current one
SiJdbcInboundManualInput  <-- manual test
SiJdbcInboundAutoParallel <-- should fire a number of message immediately
 
6:23:53 PM: Frank H F WU/HTSA/HSBC: for the poller....  it will eventually trigger a logic..
the logic need to be do 2 things

1) do a db update
2) simply a simple sleep for 5 sec.. 
6:24:23 PM: Frank H F WU/HTSA/HSBC: so we can proof the poller can handle concurrent message 
6:25:07 PM: Allen M ZHANG/HSDC/HSBC: okay 
6:25:55 PM: Allen M ZHANG/HSDC/HSBC: 1) do a db update-->it will update the message status (e.g new-->send) 
6:28:21 PM: Frank H F WU/HTSA/HSBC: do a db update -> ok.. it can whatever things..

the objective was showing..

1) each msg has its own transaction.... ( as you hv db operation.. you need demo there is a tx boundary )
2) the poller can handle concurrent income message. ( as the logic sleep for 5 sec. ).. so you must need create thread from executor service.. in order for parallel 
6:32:05 PM: Allen M ZHANG/HSDC/HSBC: okay. 
