# MVCExample shows a very simple model view controller interation. It also has an observer thrown in for good measure. 

**Copyright © 2021 Bradley M. Small**

## **Rules**

Basically the model has a chunk of data. It is a bunch of "Lorem ipsum". Each time it is accessed it returns a random chunk
by going to a random offset within the data and returning 50 characters. The application starts a timer and triggers the controller which will query the model and update the view. The model has the ability to be observed. Two textArea views are setup as observers and subscribed. There is a button that will unsubscribe and re-subscribe one of them. 

## **Code**

The source code is Java. Although using the terminology, the code does not use any java Model/View/Controller/Observer objects of code. 

## **Suggestions**

This code is intended as an exercise for me to apply my learning of Java. I am quite open to suggestions and
recommendations for improvement.

## **License**

If you wish to use any of this code for personal and/or educational purposes you may freely do so as long as you do not
claim it as your own. Give a guy a little credit if you use his work.

If you wish to make money with this code, such as publishing it in a tutorial or making a salable product I want a cut
of the action. As unlikely as this may be, simply contact me, so we can work out the details. 
