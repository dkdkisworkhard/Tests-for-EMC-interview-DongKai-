1.Description
   I implemented a storage array simulator as a web service. It provides REST API to users, all    required functions are implemented.
   I develop them in java, using myeclipse and tomcat, and depend on jersey.
   My response for test3 includes following detials:
       ¡ñ README.txt
       ¡ñ Java project, I named it 'emctest3'
       ¡ñ jersey bondle
       ¡ñ the screenshots for test result
       
   

   

1.TEST
  Anyway, we should startup this web service before do anything.
  1.1 Create one or multiple LUN.
      Type the following url into the address bar of browser to create one lun:
         "http://192.168.1.6:8080/emctest3/rest/StorageArray/createlun?lunname=dk&lunsize=100"
      If you want more lun, please change the parameters:lunname and lunsize
      NOTE: 
            lunname: the name of the lun that will be created
            lunsize: the size of the new lun

  1.2 Resize a lun
      http://192.168.1.6:8080/emctest3/rest/StorageArray/resizelun?lunname=dk&lunsize=200

  1.3 Retrieve size of a lun
      http://192.168.1.6:8080/emctest3/rest/StorageArray/retrievelun?lunname=dk

  1.4 Remove a lun
      http://192.168.1.6:8080/emctest3/rest/StorageArray/removelun?lunname=dk

  1.5&1.6
      I have no idear how to test them.


