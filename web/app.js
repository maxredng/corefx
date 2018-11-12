function kill()
{

        var v0=getParam("v0");
        var v1=getParam("v1");
        var v2=getParam("v2");
        var v3=getParam("v3");
        var v4=getParam("v4");
        var v5=getParam("v5");
        var v6=getParam("v6");
        var v7=getParam("v7");
        var v8=getParam("v8");
        var v9=getParam("v9");
        
        var ar=new Array(v0,v1,v2,v3,v4,v5,v6,v7,v8,v9);


var top="";

for(i=0;i<ar.length;i++)
    {
      
               top=top+"&"+"v"+i+"="+ar[i];
               
      
    }
        
    var newd="/corefx/start/Delete?"+top+"&confirmed=y";
    slay.action=newd;       
    
}

/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var v=""; 
var d=""; 

var load=0;
var isBlock=false;
function f(g)
{
    document.all[g].style.color="blue";
    document.all[g].style.cursor="hand";
    
}

function emergency()
{
    
    
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
        
 
        if(document.getElementById(a).checked) 
        { 
        document.getElementById(g).disabled=false; 
 
        } 
        
        if(!document.getElementById(a).checked) 
        { 
        document.getElementById(g).disabled=true; 
 
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
function on_load()
{       
   alert("here");
    var scope=getParam("scope");
    var sc=getParam("mscope");
    var sel=getParam("selected");
    var par=getParam("parent");
    var bil=getParam("block");

            if(bil=="y")
                {
                   
                     if(document.getElementById("att"))
                         {
              document.getElementById("att").checked=false;                           
                         }

                }else
                    {
                     if(document.getElementById("att"))
                         {
              document.getElementById("att").checked=true;                           
                         }

                    }

            if(scope=="edit")
            {
               
                if(sel.length<1)
                    {
                        
                        document.getElementById("checkparent").value=par;
                        document.getElementById("checkscope").value=sc;
                    }
                
            }
            
    if(scope.length<1)
    {
       
    if(scope=='')
        {
           
         var temp=window.location.href;
         var temo=temp.replace("main","Admin");
         var tem=temo;
         d="?scope=admin&selected=main&mscope=main&block=y"; 
         window.location.replace(tem+d);
         document.getElementById("main").checked=true;
        }
    
   
    }else
        {

            var sc=getParam("mscope");
            var bl=getParam("block");

            document.getElementById(sc).checked=true;
            if(par!='')
                {
                   document.getElementById("checkparent").value=par; 
          
                }
        }


    
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

