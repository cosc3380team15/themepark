<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h2>TO BE FILLED IN</h2>



	
	<SCRIPT LANGUAGE="JavaScript">

var num=0
img1 = new Image ()
img1.src = "${pageContext.request.contextPath}/images/things-to-do.png"
img2 = new Image ()
img2.src = "${pageContext.request.contextPath}/images/BartFloat.jpeg"
img3 = new Image ()
img3.src = "${pageContext.request.contextPath}/images/BurnsFerris.png"
img4 = new Image ()
img4.src = "${pageContext.request.contextPath}/images/FerrisWheel.png"



function slideshowUp()
{
num=num+1
if (num>4)
{num=1}
document.mypic.src=eval("img"+num+".src")

}

function slideshowBack()
{
num=num-1
if (num<1)
{num=4}
document.mypic.src=eval("img"+num+".src")


}

</SCRIPT>

<!-- The Image and Form Codes are Below --> 

<CENTER>
<IMG SRC= "${pageContext.request.contextPath}/images/FerrisWheel.png" NAME="mypic" BORDER=0 WIDTH="400" HEIGHT="400">
<p>

<FORM NAME="joe">


</FORM>



<button onclick="JavaScript:slideshowBack()" >Previous</button>
  <button onclick="JavaScript:slideshowBack()" >Next</button>
</CENTER>
