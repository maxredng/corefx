function on_load()
{
    //alert("test");
    var a=getParam("back");
    
    var prot=window.location.protocol;
    var host=window.location.host;
    var or=window.location.origin;
    
    if(a=="profile")
        {
             //alert(prot+"://"+host+"/corefx/start/main?scope=profile");
           document.location="main?scope=profile";
        }
}

/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var v=""; 
var d=""; 

var load=0;
var isBlock=false;
var user;

function f(g)
{
    document.all[g].style.color="blue";
    document.all[g].style.cursor="hand";
    
}



function ld()
{
    
    
}



function logg()
{
    var lo=document.getElementById("wlt").value;
    var ps=document.getElementById("wpas").value;
    d=document.location+"&lin="+lo+"&pin="+ps;
    

    
    // alert("done");   
}

function regg()
{
    
    var em=document.getElementById("wname").value;
    var pa=document.getElementById("wergpas").value;
    var spa=document.getElementById("wsepas").value;
    var nm=document.getElementById("wni").value;
    if(pa==spa)
        {

  d=document.location+"&eme="+em+"&pap="+spa+"&nam="+nm;     
 // document.location=d;
        }else
            {
  d=document.location;
  document.getElementById("wsepas").value="error: no match";
            }
}

function subform()
{
  //alert(d);
    lofo.action=d;
}

function fr(g)
{
    document.all[g].style.color="red";
    document.all[g].style.cursor="hand";
    
}


function fo(g)
{
    document.all[g].style.color="black";
    
}

function fro(g)
{
    document.all[g].style.color="blue";
    
}


function unclick(a)
{
       if(document.getElementById(a).value.length<1)
       {
    var su=a.substring(4);
    
    //alert(su);
    var lab=document.getElementById("serv"+su).firstChild.firstChild.data;
    
    var full="";
    var va="";
    if(document.getElementById("show"+su).firstChild!=null)
        {
    va=document.getElementById("show"+su).firstChild.data
    
        }
       // alert(va);
   full=lab+va;

   document.getElementById(a).value=full;
       }
}
function procText(a)
{
    
    document.getElementById(a).value="";

   
}  

function savepro()
{
    var v0=document.getElementById("textemail2").value;
    var v1=document.getElementById("textfirst").value;
    var v2=document.getElementById("textlast").value;
    var v3=document.getElementById("textcountry").value;
    var v4=document.getElementById("textcity").value;
    var v5=document.getElementById("textphone").value;
 
    var ar=new Array(v0,v1,v2,v3,v4,v5);
    var va=new Array("v0","v1","v2","v3","v4","v5");
    var res="";
                    //    alert(v0);
    for(i=0;i<ar.length;i++)
        {
                      // alert(i);
                       //   alert(ar[i].split(':').length);
            if(ar[i].split(':').length<2)
            {

                    res=res+va[i]+"="+ar[i]+"&";
                  //  alert(res);
            }else
                {
                  //  res=res+va[i]+"="+"dummy&";
                  //   alert(res);                   
                }
            
            
        }
     // alert(res);      
      
        profile.action="/corefx/start/proup?"+res+"back=profile";
     //   alert(profile.action);
}

function fd(g)
{
    document.location="?selected="+g;
    
    
}

function frd(g,s,p)
{
    document.location="?selected="+g+"&?scope="+s+"&?page="+p;
    
    
}

function direct(id)
{
    var a=document.getElementById(id).style.visibility;
           
    if(a=="visible")
        {
            

    document.location="?scope=profile";
        }
    
}



function fog() 
{ 
v=document.getElementById("s1").value; 
var bl=getParam("block");
d="?scope=edit&selected="+v+"&parent=dummy&block="+bl; 


} 

function getAction() 
{ 

var s=getFromString(d,"parent");
var sel=getParam("selected");
var pr=getParam("parent");

var dod=replaceInString(d,"parent",s,sel);

adminform.action=dod; 




} 


function replaceInString(a,key,old,noe)
{

    

         var cap=a.replace(key+"="+old,key+"="+noe);

         
    
         return cap;

    
    
}

function getFromString(a,b)
{
     var scp= new RegExp(b + '='+'([^&;]+?)(&|#|;|$)').exec(a); 
     var tr=scp[0].replace(b+'=','').replace('&','');
     return tr;
     
}

function edit(a,g) 
{ 
        
 var sav=document.getElementById(g).value;
 
        if(document.getElementById(a).checked) 
        { 
        if(a=='parent')
            {
                var bss=document.getElementById("blabel").value;
                var nm=document.getElementById("checkname").value;
                var rw=document.getElementById("checkrow").value;
                var cl=document.getElementById("checkcol").value;
                
                var va=bss+nm+"row"+rw+"col"+cl;
                document.getElementById(g).value=va;
            }
 
        } 
        
        if(!document.getElementById(a).checked) 
        { 
        document.getElementById(g).value=sav;
 
        } 
 
} 

function shut(a)
{
    document.getElementById(a).disabled=true;
    
}

//function test()
//{
//
//d="?scope=edit&selected="+document.getElementById("blabel").value;
//d=d+v;
//adminform.action=d;
//
//    
//}

function test()
{
    var top=snap();
    var sel=getParam("selected");
    var par=getParam("parent");
  
    
    var newd="/corefx/start/Edit?"+"selected="+sel+"&parent="+par+top;
    adminform.action=newd;
    
    
    
}



function toload()
{
var v4=document.getElementById("checkname").value;

var v1=document.getElementById("checkrow").value;
var block=document.getElementById("checkblock").value;
var v2=document.getElementById("checkcol").value;
var v3=document.getElementById("checkElement").value;
var v5=document.getElementById("checkvalue").value;
var v6=document.getElementById("checkparent").value;
var v7=document.getElementById("checkscope").value;
var v8=document.getElementById("checktype").value;
var v9=document.getElementById("checkisel").value;

var v;
    
    if(block=='n')
        {
        
        v=document.getElementById("checkparent").value;
        
        }else
            {
            
            v=document.getElementById("checkname").value;
            }
    
    document.location="http://localhost:8084/corefx/start/Admin?scope=upload&selected=main&mscope=main&block=y&v="+v;
    
    
}

function getload()
{
    
    var va=document.getElementById("imlink").value;
    imgform.action="/corefx/start/Upload";
    
    
}

function getVal(g) 
{ 


var p="check"+g; 
var s=document.getElementById(p).value;
//alert("incoming arg="+g+"; s="+s);
var vo=g+"="+s; 
var ss="&"+g+"="+s; 
 
var doc=v.indexOf(vo); 

//alert("doc="+doc+"; action="+v);
if(doc<0) 
{ 
 
v=v+ss; 
} 

//d="?scope=edited&selected="+g+v;
//adminform.action=d;
//alert("action="+adminform.action);
 shut("save"+g);
} 


function getNonNull(ar)
{
    var ro="";
   
   for(i=0;i<ar.length;i++)
   {
       if(ar[i])
       {
           ro=ar[i];
           break;
           
       }
   }
  
    return ro;
}

function getParam(name) 
{ 
    
        var ca=window.location.search.substring(1);  
         
        var scp= new RegExp(name + '='+'([^&;]+?)(&|#|;|$)').exec(ca); 
        
       
        
        var copp;
        if(scp)
            {
        
        var cop=scp[0].replace(name+"=",""); 
        
        var cor=cop.split('&');
        
        
        
        copp=getNonNull(cor); 
   
            }else
                {copp=''}
                
        return copp; 
        


} 

function insertParam(key,noe)
{  
  
         var old=getParam("mscope");
    
         var temp=window.location.href;
         var ca=window.location.search.substring(1); 
         var ba=window.location.search.substring(0);
         var cap=ca.replace(key+"="+old,key+"="+noe);

         var dou=ba+cap;
    
         window.location.replace("?"+cap);


}

function setParam(key,noe)
{  
  
         var old=getParam(key);
    
         var temp=window.location.href;
         var ca=window.location.search.substring(1); 
         var ba=window.location.search.substring(0);
         var cap=ca.replace(key+"="+old,key+"="+noe);

         var dou=ba+cap;
    
         window.location.replace("?"+cap);


}

function change(a)
{
 var b="";           
var ele=document.getElementsByTagName("input");



for(i;i<ele.length;i++)
    {
 
       if(ele[i].type=="radio")
           {
                      
                      
               if(ele[i].id!=a)
                   {
                   
              document.getElementById(ele[i].id).checked=false;         
                   }else
                       {
                           
             document.getElementById(a).checked=true;
           //  var oldi=getParam("mscope");
    
             b=a;
                       }
               
           }
        
        
    }
    
    insertParam("mscope",b);
    
    
    
}

function unblock()
{
    
    
    if(document.getElementById("att").checked)
        {
       
            setParam("block","n");
            isBlock=true;
        }else
            {
              
              setParam("block","y"); 
              isBlock=false;
            }
    
    
}

function drill()
{
 
    var sop=document.getElementById("s1").value;
     
    setParam("selected",sop);
    
    
}

function cleanDesc()
{
    var val=document.getElementById("desctxt").value;
    var vav=val.replace("<font>",'');
    var fin=vav.replace("</font>",'');
    document.getElementById("desctxt").value=fin;
    
}

function getview()
{
    var temp=window.location.href;
    var ar=temp.split("?");
    
    var v1=ar[0];
    var v2=ar[1];
    
    var sco=getParam("mscope");
    var sel=getParam("selected");
    var tem=v1.replace("Admin","main")+"?scope="+sco;
    
    window.open(tem,"preview");
    
    
}

function person()
{
    document.getElementById("meatframe").src="/corefx/start/main?scope=live&sub=profile";
    //alert(document.getElementById("meatframe").src);
    document.location.reload();
    
    alert("djudu");
}

function showno()
{
    var obm=document.getElementById("2mat");
    alert("2mat");
    alert(obm.firstChild.data);
    var m2=document.getElementById("2mat").firstChild.data;
    alert("test1");
    if(m2.length<1)
        {
            alert("test2");
            document.getElementById("2mav").style.visibility=hidden;
            alert("test3");
            document.getElementById("2mat").style.visibility=hidden;
            document.getElementById("2hiv").style.visibility=visible;
        }
    
}


function popimg(a)
{
    var r=document.getElementById("checkname").value;
    
    var p=document.getElementById("checkparent").value;
    
    if(r=='src')
        {
            if(a=='checkvalue')
                {
                   document.getElementById(a).value="/corefx/start/img~id@"+p;
                    
                }
            
        }
    
}

function prodit()
{
    //alert("1");
    replaceIt("email2");
    replaceIt("city");
    replaceIt("first");
    replaceIt("last");
    replaceIt("country");
    replaceIt("phone");
    
}

function replaceIt(a)
{
    var txt="serv"+a;
    var show="show"+a;
    var inp="text"+a;
    // alert(txt);
    //var tex=document.getElementById(show).firstChild.data;
    // alert(show);
    
//    if(tex==null)
//        {
            document.getElementById(txt).style.visibility="hidden";
           // alert(document.getElementById(txt).style.visibility);
            document.getElementById(show).style.visibility="hidden";
            document.getElementById(a).style.visibility="visible";
            var va=document.getElementById(txt).firstChild.firstChild.data
            if(document.getElementById(show).firstChild!=null)
                {
                   
                   
                   document.getElementById(inp).value=va+document.getElementById(show).firstChild.data;
                   
                }else
                    {
                        document.getElementById(inp).value=va;
                    }
            
//        }else
//            {
//                
//            }
//    
}

function goimg()
{
    var v1=document.getElementById("idtxt").value;
    proform.action="/corefx/start/Admin?scope=Upload&id="+v1;
    
    
}

function goedit()
{
    var vo=snapp();
    var v1=document.getElementById("idtxt").value;    
    proform.action="/corefx/start/Edit?"+vo+"&id="+v1;
    
}

function goadd()
{
 
    var vo=snapp();
 
    proform.action="/corefx/start/Add?"+vo;
    
    
}

function toadmin()
{
     
 //alert("test");
     var temp=window.location.href;

var sel="main";
var scp="main";
var par="root";
         var ar=temp.split("?");

 //  alert(imgform.action);
   imgform.action="/corefx/start/Admin?scope=Admin&selected="+sel+"&mscope="+scp+"&block=y";
    
    
}

function toprod()
{
var s=document.getElementById("imlink").value;
imgform.action="/corefx/start/Admin?scope=prod&id="+s;
}

function topro()
{

imgform.action="/corefx/start/Admin?scope=prod&";
}



function topr()
{
    var v=document.getElementById("checkname").value;
    
     
    
         var temp=window.location.href;


         var ar=temp.split("?");

   
         window.location=ar[0]+"?scope=prod&id="+v;

}

function loadField(lid,mid)
{
    var vr=getParam(lid);
    document.getElementById(mid).value=vr;
    
}


function snapp()
{
    var v1=document.getElementById("idtxt").value;
    var v2=document.getElementById("cattxt").value;    
    var v3=document.getElementById("catprestxt").value;
    var v4=document.getElementById("partxt").value;
    var v5=document.getElementById("pardestxt").value;
    var v6=document.getElementById("lantxt").value;
    var v7=document.getElementById("desctxt").value;
    
    
var ar=new Array(v1,v2,v3,v4,v5,v6,v7);

var res="";

for(i=0;i<ar.length;i++)
    {
      if(i>0)
          {
               res=res+"&"+"v"+i+"="+ar[i];
          }else
              {
                res=res+"v"+i+"="+ar[i];  
              }
      
    }

return res;

}

function addTo() 
{
var sel=getParam("selected");
var sco=getParam("scope");
var par=getParam("parent");
var sc=getParam("mscope");

var sl=document.getElementById("s1").value;

if(sl.length>0)
    {sel=sl;}

d="?scope=edit&parent="+sel+"&mscope="+sc+"&block=y";

adminform.action=d;


}

function snap()
{
var v4=document.getElementById("checkname").value;
var v1=document.getElementById("checkrow").value;
var v10=document.getElementById("checkblock").value;
var v2=document.getElementById("checkcol").value;
var v3=document.getElementById("checkElement").value;
var v5=document.getElementById("checkvalue").value;
var v6=document.getElementById("checkparent").value;
var v7=document.getElementById("checkscope").value;
var v8=document.getElementById("checktype").value;
var v9=document.getElementById("checkisel").value;

var ar=new Array(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10);

var res="";

for(i=0;i<ar.length;i++)
    {
      
               res=res+"&"+"v"+i+"="+ar[i];
               
      
    }
     return res; 
    
}



function append()
{
    var top=snap();
  
    
    var newd="/corefx/start/Add?"+top;
    adminform.action=newd;
    
    
    
}

function remove()
{
     var top=snap();
  
    
    var newd="/corefx/start/Delete?"+top+"&confirmed=n";
    adminform.action=newd;   
    
}

