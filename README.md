# Glaucoma App on Android Studio
Development of an Android App based off a previously built iOS App

## Glac-at-home-a Original iOS Project

Link: https://github.com/cchriskeach/Glaucoma-App

Nota Bene: I, Ryan Hankee, am not attempting to copy the work found on this project. The developers of the original project allowed me to see their presentation of this project, and are fully aware that I am attempting to recreate at least their interface for android products.

## Introduction

This Version of this Project, and all other material found on this page, were completed by me, Ryan Hankee, during the summer of 2022, during my intern/research program with University of Pittsburgh's head of the Electrical and Computer Engineering Department, Dr. Dickerson. The over arching goal of this project was slightly different than those who attempted this before me. For them, this was a design project with a focus on making a project that would have a positive influence on society. I, on the other hand, used this project as a chance to familiarize myself with front end development. I have not had many chances in my personal collegiate career to work on the front end, especially User Interfaces. The class that most people learn about that in at the University of Pittsburgh randomly had me create a hardware interface, with no software components. So I decided to take this chance to see what User Interface, as well as mobile app developement.

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
    
3. any error with "artifact" in the message
    
    The artifact error message seems to be indicative of a depricated library. From my current understanding, there have been some recent changes to Android Studios primary libraries that are causing many old libraries to no longer be supported. 
    - As of March 31 2021, the jcenter() repository no longer received updates
    - As of February 1st 2022, the jcenter() repository was completely shut down
    - jcenter() has been replaced with mavenCentral()
    - mavenCentral does not seem to cover all aspects of jcenter()
    - Switching from jcenter() -> mavenCentral(): https://onesignal.com/blog/android-migrate-jcenter-to-maven-central/


   Oddly, it does not seem as though Android Studio has made it so that mavenCentral is the default instantiation, causing errors in repositories who are using jcenter() still, and finding that the repository is depricated and therefore it cannot be used. Furthermore this seems to hinder many of the chart libraries, as I have found a multitude of forums with people reporting similar complaints to those of my own, with the same libraries, that being any and all of the libraries that make creating charts possible. Due to being uncertain as to whether or not this is an issue with the linux IDE, or the IDE in general (seeing ass most buildscript files seem to look very different than my own) I have devided to place this information in the device secton, not the IDE section.
      
### Android Studio Information

1. Kotlin to Java
2. Create a Virtual Device
3. Icon Manipulation
4. Importing Custom Widgets
5. Color Manipulation

### Kotlin Library Information

1. build.gradle
2. String Warnings

### App Specific Information



### References and Sources

1. Calculator: https://www.youtube.com/watch?v=FjrKMcnKahY
2. SQL info: https://www.youtube.com/watch?v=9LYn-OBO5qE
3. Bluetooth info: https://www.youtube.com/watch?v=Oz4CBHrxMMs
4. Timer App: https://www.youtube.com/watch?v=E40uAdVr85M
5. Chart info: https://www.youtube.com/watch?v=kUrmZjUOEyc
