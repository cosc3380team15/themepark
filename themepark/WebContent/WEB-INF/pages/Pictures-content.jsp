<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>Duff Garden's Slideshow</h2>



	
	<SCRIPT >

var num=1
img1 = new Image ()
img1.src = "${pageContext.request.contextPath}/images/things-to-do.png"

img2 = new Image ()
img2.src = "${pageContext.request.contextPath}/images/BartFloat.jpeg"

img3 = new Image ()
img3.src = "${pageContext.request.contextPath}/images/BurnsFerris.png"

img4 = new Image ()
img4.src = "${pageContext.request.contextPath}/images/FerrisWheel.png"

	img5 = new Image ()
img5.src = "${pageContext.request.contextPath}/images/duffballoon.png"

	img6 = new Image ()
img6.src = "${pageContext.request.contextPath}/images/fish.jpg"

	img7 = new Image ()
img7.src = "${pageContext.request.contextPath}/images/food-and-drink.png"

	img8 = new Image ()
img8.src = "${pageContext.request.contextPath}/images/homergut.gif"

	img9 = new Image ()
img9.src = "${pageContext.request.contextPath}/images/HuckRiver.jpg"

	img10 = new Image ()
img10.src = "${pageContext.request.contextPath}/images/rides.png"

	img11 = new Image ()
img11.src = "${pageContext.request.contextPath}/images/shamuPic.jpg"

	img12 = new Image ()
img12.src = "${pageContext.request.contextPath}/images/simpsonsBeerGarden.jpg"

	img13 = new Image ()
img13.src = "${pageContext.request.contextPath}/images/RiverRdie.png"

	img14 = new Image ()
img14.src = "${pageContext.request.contextPath}/images/RollerCoast.png"

	img15 = new Image ()
img15.src = "${pageContext.request.contextPath}/images/winebar.jpg"

	img16 = new Image ()
img16.src = "${pageContext.request.contextPath}/images/sushiRestaurant.jpg"



function slideshowForward()
{
num=num+1;

if (num==17)
{num=1}

document.mypic.src=eval("img"+num+".src")

}

function slideshowBack()
{
num=num-1

if (num==0)
{num=16;}

document.mypic.src=eval("img"+num+".src")


}

</SCRIPT>

<!-- The Image and Form Codes are Below --> 

<CENTER>
<IMG SRC= "${pageContext.request.contextPath}/images/FerrisWheel.png" NAME="mypic" BORDER=0 WIDTH="400" HEIGHT="400">
<p>




<button onclick="JavaScript:slideshowBack()" >Previous</button>
  <button onclick="JavaScript:slideshowForward()" >Next</button>


<h5>Submit More Photos to PhotoSubmission@Duff.com</h5>
</CENTER>