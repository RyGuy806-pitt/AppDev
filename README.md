# Glaucoma App on Android Studio
Development of an Android App based off a previously built iOS App

## Glac-at-home-a Original iOS Project

Link: https://github.com/cchriskeach/Glaucoma-App

Nota Bene: I, Ryan Hankee, am not attempting to copy the work found on this project. The developers of the original project allowed me to see their presentation of this project, and are fully aware that I am attempting to recreate at least their interface for android products.

## Introduction

This Version of this Project, and all other material found on this page, were completed by me, Ryan Hankee, during the summer of 2022, during my intern/research program with University of Pittsburgh's head of the Electrical and Computer Engineering Department, Dr. Dickerson. The over arching goal of this project was slightly different than those who attempted this before me. For them, this was a design project with a focus on making a project that would have a positive influence on society. I, on the other hand, used this project as a chance to familiarize myself with front end development. I have not had many chances in my personal collegiate career to work on the front end, especially User Interfaces. The class that most people learn about that in at the University of Pittsburgh randomly had me create a hardware interface, with no software components. So I decided to take this chance to see what User Interface, as well as mobile app developement.

## To Get Started

The project is the WorkingPrototype directory. From Here, each level of files has its own READ.me file, if it needs one. Most of these files are just instructions on properly unzipping files into their intended directory. If these are not followed correctly, the project will not run. Furthermore, if you need to troubleshoot this project, start a new project with the 3 tab template, and move all the gradle, XML, and java files to that project, as most of the memory issues with this project are caused by intermediate tests run on the code to ensure it will not break. If there is no READ.me file in a directory, there are no more READ.mes below it, and there are no instructions to change anything at that file level specifically.

## Topics Covered
  - Multiple Activity Interaction
  - Multiple Fragment Interaction
  - Multiple Activity and Fragment Interaction
  - Object instantiation with Widgets
  - Icon instatiation with Widgets
  - Event Triggered Protocols
  - Manipulation of Custom Input Information
  - Custom Widget Importing
  - Custom Graph/Data Analysis Importing
  - Establishing Connection with a Bluetooth Device

# Collected Information

### Topics
1. [System and Device Information](#system-and-device-information)
2. [Android Studio Information](#android-studio-information)
3. [Kotlin Library Information](#kotlin-library-information)
4. [App Specific Information](#app-specific-information)
5. [References and Sources](#references-and-sources)

### System and Device Information

1. These Projects were all completed on a HP Laptop 15-ef1xxx, running Ubuntu20.04 as the Operating System

2.  /dev/kvm error

    Android Studio requires the allowances to run a KVM inorder to virtually simulate one of their cellular devices. Android Studio provides the option of running a virtual machine for all of their devices, as well as customizing those devices incase that has been done to the phone which is intended to run the app being created. Before attempting anything with Android Studio, you should check that your device is able to run a KVM at all:
    1. run: sudo install cpu-checker
    2. run: egrep -c '(vmx|svm)' /proc/cpuinfo
    3. if output is >0, you may continue
			- if output is 0, your computer cannot run virtualization software
		4. run: kvm-ok
			- if KVM is not enabled, you will see that here, enable Virtualization Technology in BIOS settings
    
    In order to edit BIOS settings:
    - You need to know what button allows you access to ***your specific*** laptop model's BIOS settings

    For example, my HP Laptop ef1xxx's BIOS access button is **esc**, so:
    
    1. First, you will have to restart your laptop, however read at least the next step before doing so
    2. As soon as you have pressed restart, rapidly press your laptops BIOS access button until the system has turned on
    3. If you have the right BIOS access button, then your laptop should not have started as it normally does
    4. There will be an option to edit BIOS settings, in my case this is accessed via F10
    5. Find the Configuration Tab, and travel there
    6. Here you should only see a few options, and assuming you did not do this for fun, you should see a setting called Virtualization Technology and it should be Disabled
    7. Move the cursor over 'Disabled' and hit enter
    8. Move the cursor over 'Enable' and hit enter
    9. Travel to the last tab, move the cursor over 'save and exit', and click enter

    Now that we know you have the ability to run a KVM, we also need to install the proper packages:
    
    1. run: sudo apt install qemu-kvm
    2. run: sudo adduser [device username] kvm  ***Device Username is your personal user***
    3. run: sudo apt-get update
    
    See [Android Studio Information](android-studio-information) for information on creating your Virtual Machine one Android Studio
    
    **NOTA BENA**: This seems to be the case for my computer, and probably most others as well, these BIOS setting changes will only remain until your laptop has completely shut down. Sleep mode does not seem to reset these settings, however upon dying my laptop delivers a message saying it has restored its default settings. There is a way to save current settings as default settings, however I will not be going over that here, as it is not very relevant to the topic at hand.
    
3. any error with "artifact" in the message
    
    The artifact error message seems to be indicative of a depricated library. From my current understanding, there have been some recent changes to Android Studios primary libraries that are causing many old libraries to no longer be supported. 
    - As of March 31 2021, the jcenter() repository no longer received updates
    - As of February 1st 2022, the jcenter() repository was completely shut down
    - jcenter() has been replaced with mavenCentral()
    - mavenCentral does not seem to cover all aspects of jcenter()
    - Switching from jcenter() -> mavenCentral(): https://onesignal.com/blog/android-migrate-jcenter-to-maven-central/


   Oddly, it does not seem as though Android Studio has made it so that mavenCentral is the default instantiation, causing errors in repositories who are using jcenter() still, and finding that the repository is depricated and therefore it cannot be used. Furthermore this seems to hinder many of the chart libraries, as I have found a multitude of forums with people reporting similar complaints to those of my own, with the same libraries, that being any and all of the libraries that make creating charts possible. Due to being uncertain as to whether or not this is an issue with the linux IDE, or the IDE in general (seeing ass most buildscript files seem to look very different than my own) I have devided to place this information in the device secton, not the IDE section. See [Kotlin Library Information](#kotlin-library-information) for more
      
### Android Studio Information

1. Kotlin to Java
	
	This feature can be very useful for more basic applications, however it currently seems to have a few problems. While debugging the AnyChart library, and attempting to get it to work in Kotlin, I came across a rather strange discovery. AnyChart itself, does not seem to be broken, and actually functions rather easily while using Java to be created. However, Kotlin does not go as smoothly. I had no success attempting to add anyChart to any Kotlin project after rewriting the Gradle Script and Builds a large multitude of times. It seems that there were already problems with this Prior to the Feb 2022 update, but now there is not a found solution in order to solve this discrepency. 
	After creating a successful project with AnyChart in java, I attempted to switch the file to Kotlin. The project did not even finish building the gradle before sending a slew of error messages, none of which had appeared on the java end of things. I think MavenCentral will continue to make any old custom Widgets accessible in Android Studio in the future.
	
2. Create a Virtual Device

	Before any app can be created with Android Studio you will need access to one of two things. A. A samsung device. It does not really matter what the device is, assuming that it is relatively similar in its capabilities to the device you primarily intend your app to be for. This way you will be able to download and launch your app in order to test it and see how it runs, the problem with this method is that you will need to redownload the app each time you make an adjustment in order to witness the change and the effects that it has had.
	The other option is creating a Virtual Device. Please see more [System and Device Information](#system-and-device-information) for more information about it your CPU is capable of running a Virtual Machine in the first place. Assuming you have checked all of that off, all you need to do is go into the Android Studio IDE and look at the right hand side of the screen. Click Device Manager, and click create device under the virtual tab. I would recommend going for the newest model Nexus or Pixel, as they seem to have compatibility across most of the APIs. Once you have created a Device, that will become the default that is run on while running and testing the application.
	
3. Bluetooth Device
	
	The requirements for using a bluetooth device on android studio have changed since the Feb 2022 update
	
	    <uses-permission android:name="android.permission.BLUETOOTH" />
    	<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
    	<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
    	<uses-permission android:name="android.permission.BLUETOOTH_SCAN" />
    
    	
	These should all be added to your Manifest file, at line 5. The disable command that used to come with the bluetooth device now requires special
permissions to be checked be for the user can access them. In order to disable this
	
	File>>Settings>>Editor>>Inspections>>Android>>Lint>>Correctness>>find missing permissions and uncheck its box
	
4. Icon Manipulation

	When looking to use another Image not already downloaded by your file, you will want to go to the project folders and find where "drawable" is. Once you have found this, left click>>New>>Vector Asset>>click on the image icon, and replace it with something of your choice. Once you do this, save the vector asset with whatever name you would like. now when calling upon the image, usually it will be the src attribute that you want to send it to, so
	
	android:src="@drawable/FILE_NAME_HERE"
	
5. Importing Custom Widgets
	
	This can be completed via following a majority of Github pages ReadMe files, for which you are taking the widget from, however the most basic and nearly always required step is going to the build.gradle(Module) and scroll to the bottom, you should see something like
	
	dependencies {

    		implementation 'androidx.appcompat:appcompat:1.4.2'
    		implementation 'com.google.android.material:material:1.6.1'
    		implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    		testImplementation 'junit:junit:4.13.2'
    		androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    		androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
	}
	
	In which you will want to add "implementation 'YOUR_LINK_HERE'"
	
	You may need to edit the build.gradle(Project) file in some cases, as well as gradle.properties on occasions.
	
5. Color Manipulation
	
	Most color calling is done via entering the hex value of the color you would like to appear as the background attribute for different objects. However if you would like to only make a specific area, such as a bubble behind an image a different color, you must go about this a little different in order to not overfill or underfill the area you are intending to place the color. Through a similar process as the Icon Manipilation: left click drawable>>New>>Drawable Resource File. Once you have done this you will have a file that you can edit at will. For color specifically you will want to change the "selector" option to "shape". Here is an example, with the same one as well as others all being found in the SettingsUI project.
	
		<?xml version="1.0" encoding="utf-8"?>
		<shape xmlns:android="http://schemas.android.com/apk/res/android" android:shape="rectangle"
   		 >

    		<solid android:color="@color/notifications"/>
    		<corners android:radius="100dp"/>
		</shape>
		
6. Fragment Warning

When using any of the prebuilt templates for your app, beware of the debugging process you take. You may add a relative layout or another widget, and be given a warning that you need to replace the fragment with another widget like a RelativeFragment. This will continually make the app crash if the template was build using said fragment. Ignore this warning and it seems to go away at the end, or be replaced with another error/warning. The purpose of this other widget is to be something that can only be pulled up once while running the app before it is removed from the app, which is not what we want to occur in this example.

### Kotlin Library Information

1. build.gradle

Just as I have myself, I am certain a lot of people will look at a large multitude of the online examples and tutorials created on android studio, and be confused why the initial project build before editting is different than what other people's looks like. I have come to discover a few things: these files seem to be created based off 2 key components: operating system, and java SDK. depending what you have downloaded and how it is operating, your gradle build is going to have different requirements and standards than that of your computer related collegues. Noteably: many of the old settups on youtube should not be copied or use, those libraries are beginning to be depricated, and will realistically make those tutorials and examples worthless by the time those libraries have had time to develope. So, as a standing point, unless a tutorial adds something specifically to the build.gradle files, do not edit them to mirror what you may see on someone else screen.

Update 1
org.gradle.api.internal.artifacts.ivyservice.DefaultLenientConfiguration$ArtifactResolveException: Could not resolve all files for configuration ':app:debugRuntimeClasspath: After doing further research I have found, https://www.youtube.com/watch?v=4oPPG7g0MV0. Althought I do not necessarily need to implement this fix, it seems to fix the problem that I was having in the AnyChart library section of this information. It seems as though this is intended to be a video on using Kotlin with the new build.gradle set up, however it is very difficult for me to understand, and therefore I am not 100% certain what the overall purpose of this video is, other than it seems to fix something.

2. String Warnings

The String warning has a rather easy fix, and is moreso just an eyesore especially when debugging than it is an actual hinderence. ALl you need to do to get rid of the warning is type in the string normally. Hover over the string with your mouse until the light bulb appears to the left. Clikc the lightbulb, and click the first option. A pop up window will pop and and you will hit ok, and the warnin gshould disappear after that. You will have to do this for each different string you wish to implement.

3. AnyChart Library and Kotlin

After a large multitude of trial and error I have reached a conclusion on the Chart libraries, not only AnyChart but PhilJay, etc, have paradoxical requirements after the Feb 2022 update. Kotlin projects are automatically set up in a way where it is using the android studio IDE to perform the java equivalent functions. However, our beloved chart libraries were created well before this point. Because of this it seems the Kotlin specifically is no longer capable of running AnyChart. Even after a successful project build in java out of only the Main activity, transferring the java file to a kotlin file still breaks the project. This will be my reasoning for moving from being Kotlin focused, to Java focused, in order to avoid having a similar issue again. My belief is the anychart libraries are not yet built to support Kotlin post update. This is furthered by the fact that it seems as though the initialization is completely different than it was before, where charts are not instantiated in the XML file but rather in the java file itself, after declaring a generalized chart object. This set up can be found in WorkingPieChart.zip.

### App Specific Information

1. Bluetooth Tonometer

The idea of performing a tonometer test at home was not realistic until more recent times. Due to this I have had a very difficult time finding any information that a bluetooth tonometer would be attempting to send, because most of the tonometers that exist either A. are not bluetooth or B. are designed to interface with a specific software platform that is not displaying what they are doing with the data they receive from the device. This has resulted in the functionality of this app being a problem. I do not know specifically what new data is constantly, or even worse inconsistently, being received by the device,and what needs to be done with that information, as well as not having a proper database to actually store specific client information in. This project will be made in a way that it assumes a user has been logged in, and the app will have access to static data values as representation, which could/should easily be able to be replaced with information store and received from a database

2. AnyChart Library Issues

In the process of creating my prototype, I have discovered an Issue that seems to be being ignored by the library creators. When adding multiple charts to a singular activity or fragment, and they are contained within a scrollview, the page has a difficult time loading more than a singular chart at a time, so: whichever chart comes last sequentially in the code is the one that will appear, in the intended place. The other charts appear white. The only reference to resolve this problem from the creators can be found in [References and Sources](#references-and-sources) #8, but even in that conversation, the creator says there is nothing else he can refer us to if the intended method is not working correctly.

Update: this method does allow for multiple charts to appear, however it is very order specific, and will not work otherwise.

3. Basic App Layout

At this point in time there are 3 sections to the app. They will be referred to here as "Test Page", "Data Page", and "Settings". Here I will leave information on the intended uses of this project, as well as any manipulation that will go into this.

A. Test Page
	
This is a rather simplistic part of the app that simply contains a button. This button will trigger the beginning and end of a test, which will send the recorded data to the accounts specific profile, once a databases information has been linked to the app. The primary purpose as of now is for a tonometer to be connected to the app, and then record pressure readings, duration of time, and more, however without an actual tonometer, there is not a good way to assume what inputs will be coming in. Because of this there is not much functionality to this page. Going forward, I plan to add the bluetooth connection button to this page, as it seems to be more logical to place it there, than on the login screen as originally seen on te iOS version of the app. I also intend to change the design of the button to be larger and more noticeable, due to the intended clientel this app is for, however at this moment in time the focus has primarily been on having the app running with only the absolutely necessary functionality.

![Screenshot from 2022-07-19 11-59-50](https://user-images.githubusercontent.com/77860961/179801565-1b3f9936-6799-4065-bd27-6eb990eea8a7.png)
![Screenshot from 2022-07-21 12-48-21](https://user-images.githubusercontent.com/77860961/180269652-eaaacf39-0214-4a3a-9ae6-1f888a4a3757.png)

	
B. Data Page
	
Here all the users personal data will be accessible to them and displayed via chart. This page, once again, is rather simple, and currently contains 3 charts, using static data values as examples for the display. Once again, when a database's information is linked to the app. These charts are provided by the AnyChart library, and currently uses 2 bar graphs and a line graph as the displays. The great part about using AnyChart is the flexibility of the library. Rather than each chart type being different, they are set up as an object of type AnyChart. In more simple terms, the widget used for the chart is initially just a large blank square on the page. Once you have designated in the Java or Kotlin file what type of chart you would like to appear there, that is when the data will be used to create that graph. Unless you go into a 3+ dimensional data format, all the charts have data added to them with the same commands, so changing simply the object type is enough to change the output of the chart on the page. Here I will show you how to add another chart, due to there being some issues with the library when trying to display multiple charts on one fragment.\

YOUR_PROJECT_ACTIVITY.java

	**In onCreateView**
	AnyChartView chart = root.findViewById(R.id.chart);
	APIlib.getInstance().setActiveAnChart(chart);
	
	Cartesian Column = AnyChart.column();
	
	List<DataEntry> dataEntries = new ArrayList<>();
	//fill dataEntries
	
	Column.data(dataEntries);
	Column.title("Tests per Day");
	
	Column.background().fill("@color/white");
	chart.setChart(Column);
	
	
Please also note: if you are seeing white squares rather than a chart appear, you have no completed the set up correctly. If you are experiencing this my top recommendation would be to make sure you have changed all variable names for your new graph. using the same object and rewriting its values will not work, and essentially just remove the data from the code in its entirety, to the point that neither graph trying to use those values will display anything. The only values allowed to be shared are that of the data being entered.

![Screenshot from 2022-07-21 12-48-12](https://user-images.githubusercontent.com/77860961/180269642-78111d35-f08c-4f07-946c-8f9cf50999d7.png)
	
C. Settings Page
	
Here I have set up a basic interface for a multitude of random settings at the moment. Seeing as I don't have much information on who will be using the app, and what settings adjustments would be useful, there is not a lot of functionality for me to add. However, I have set this up so creating new tabs or sections is as simple as adding another block of code to the XML file. You will be easily capable of adjusting what information that setting takes (text input, switch, or display), as well as the color and icon associated with that setting. Adding a new color is explained in [Android Studio Information](#android-studio-information), but adding new settings visually is performed as follows.

	**In Settings XML**
	<RelativeLayout
	   android:layout_width="match_parent"
	   android:layout_height="wrap_context">
	   
	   <TextView
	      android:layout_width="wrap_context"
	      android:layout_height="wrap_context"
	      android:layout_marginLeft="60dp"
	      android:layout_marginTop="10dp"
	      android:text="Night Mode"
	      android:textColor="#000000"
	      android:textStyle="bold"></TextView>
	    
	   <ImageView
	      android:id="@+id/nightModeIcon" //insert icon of your choices as a drawable file here
	      android:layout_width="40dp"
	      android:layout_height="40dp"
	      android:layout_marginLeft="10dp"
	      android:padding="12dp"
	      android:background="drawable/round_back_night_mode" //insert drawable file with custom chape design here
	      android:src="drawable/ic_baseline_nights_stay_24"></ImageView>
	      
	   <androidx.appcompat.widget.SwitchCompat
	      android:layout_width="wrap_context"
	      android:layout_height="wrap"
	      android:layout_marginLeft="10dp"
	      android:layout_centerVertical="true"
	      android:switchMindWidth=50dp"
	      android:theme="@style/nightModeSwitch"></androidx.appcompat.widget.SwitchCompat>
	      
	</Relative Layout>
	
![Screenshot from 2022-07-21 12-46-55](https://user-images.githubusercontent.com/77860961/180269633-e53cf857-0927-4c96-b354-276a326d4ae9.png)

D. Next Interface steps
	
The part of this that I wish I had had more time to work on involves issues with Android Studios premade templates, and how fragments and activities interact. Adding a activity before the primary activity (that being the apps current state), would complete this app, as that would be the login page. However upon adding this a multitude of different ways, it seems to cause the app to crash once any tab is clicked more than once. Furthermore, this feature, although relevant, is rather useless unless it is actually being checked against a database, which once again is simply not something I had time to perform. Beyond this the interface is complete to a degree that it should be easily customizable, but at the same time most primary functionality in the app would not change.

I also have attempted to add bluetooth connectivity to this app. However, as mentioned above I have had a multitude of problems with adding new fragments to a project. There is a high probability that I may be performing this process incorrectly, however I have found no data to support that claim. The problem that this creates for bluetooth seems to be an android issue. From what I have gathered in online forums, google has not released a large amount of information about their bluetooth library. Because of this it does not seem like anyone has made a button, like that in Chris and Spencer's project, where you can click a button to connect to whatever the most easily available bluetooth device is. Rather, you need to create an entire list view of all available devices, which you can see an example of in my BluetoothExample project. The problems create a paradox as follows: the point of this app is for its to be visually simple, as the clientel are typically visually impaired to some degree. However, adding a separate fragment to open up does not currently seem to be an option. So I could attempt to place a list view on the interface as it stands, but that really only seems possible in the settings tab with an added scroll view, but at that point it should probably still be its own fragment. The ScrollView if added to the test page would be very small, and not really optimal for finding the intended device, especially for someone who is visually impaired. In the initial project, the bluetooth button was added to the login screen, which I believe would be the best place for it to be located, once someone has created a login page, even if it still needs to be a scrollView listView type of xml file.
	
E. Additional Future Steps
	
Any one with experiences in databases could quickly take this project to the next level. By adding actual account information and a place for data to be stored, as well as switching the static values with those coming from the account information, the app would be fully functional, minus whatever actions would be intended to be performed by the official settings.


### References and Sources

1. Calculator: https://www.youtube.com/watch?v=FjrKMcnKahY
2. SQL info: https://www.youtube.com/watch?v=9LYn-OBO5qE
3. Bluetooth info: https://www.youtube.com/watch?v=Oz4CBHrxMMs
4. Timer App: https://www.youtube.com/watch?v=E40uAdVr85M
5. Chart info: https://www.youtube.com/watch?v=kUrmZjUOEyc
6. SettingsUI: https://www.youtube.com/watch?v=Px5u3wz3g-U
7. Kotlin fix: https://www.youtube.com/watch?v=4oPPG7g0MV0
8. Multiple Charts: https://github.com/AnyChart/AnyChart-Android/wiki/Multiple-charts-in-a-single-layout

