About
=====

At the moment a simple struts2 tag to render emailto anchors in some sort of of obfuscated format. 

*Be warned:* It is more a proof of concept and thus has no real obfuscation, html escaping, or tests. Yet.
If it works out I plan to add the option to obfuscate all addresses rendered to non logged on users.

Usage
=====

The attributes currently supported are:
* value: The OGNL expression to locate the email address to use. Will default to "top" if not used.
* writeWithJavaScript: either *true* or *false*. If true uses JavaScript to render element. Default is false.
* default: The email address to use if nothing is found by the OGNL expression. 
* id: The html element id. Will not be output if not present.
* clazz: The html class. Will not be output if not present.
* title: The html title. Will not be output if not present.
* style: The style to use on the tag. If you must.

JSP:
----

    <%@ taglib prefix="versi" uri="WEB-INF/versi.tld"%>

    <p>You can be reached at: <versi:emailAnchor id="2" clazz="test" title="A jolly person" style="background-color:yellow;" value="email" default="martin.paulo@gmail.com" writeWithJavaScript="true" /></p>

Velocity:
---------

    <p>You can be reached at: #semailAnchor("value=email" "title='Contact us email address'" "default=martin.paulo@gmail.com")</p>

FreeMarker
----------

    <p>You can be reached at: <@versi.emailAnchor value="email" title="Help email address" default="martin.paulo@gmail.com" /></p>

Licence
=======
GPL: See doc/LICENCE