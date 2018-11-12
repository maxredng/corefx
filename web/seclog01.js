
var v="";
 var d="";
 var isOMO=false;
var load=0;
var isBlock=false;
var user;
var streight=true;
var ison=false;
var bshow="fdiv";
var zer='0';
var mprice = 0;
var rcLeft=0;
var rcRight=0;
var rcTop=0;
var rcBottom=0;
var cur="";
var par="";
var vol="";
var elementname;
var ID;
var CONTENT;
var type;
var CLASS;
var ONCLICK;
var href;
var src;
var isel;
var name;
var lang;
var cat;
var extra;
var lan;
 var namo;
var count = 0;
var comment;
var xx = ["project","exone","extwo","exthree"];
var grid = [];
var ex = true;
var ext = [];
var volume;
var ctgr;
var listString;
var prod;
var lfp;
var path="/corefx/start/";
var _x;
	  var _y;
var opened=false;
var sle=[];
var field=["id","name","content","class","src","href","value","onclick","type","intype","onmouse","offmouse","onchange","width","height","row","col"];
var isAt=[true,false,false,true,true,true,true,true,false,true,true,true,true,true,true,false,false];
var sel="none";
var hid = ["jin","papa"];
var stl;
var title;
var wid;
var descr;
var avail;
var category;
var cat_pres;
var series;
var price;
var parent;
var pardes;
var exp = false;
var mytext;
function addtest()
{
var suite = getParam("suite");
var test = getParam("selected");
window.open(path+"main?scope=testmanager&suite="+suite+"&test="+test);
}
function saveversion()
{
var area = getParam("area");
document.location.href = path + "main?scope=stage&area=" + area +"&switch=version";
}
function saverecent()
{
addParam("switch","saverecent");
}
function openrecent()
{
addParam("switch","openrecent");
}
function expandtest(a)
{
var suite = getParam("selected");
window.open(path+"main?scope=set&selected=" + a + "&suite=" + suite);
}
function openscope(a)
{
window.open(path+"main?scope=suite&selected="+a);
}
function opentest()
{
alert();
}
function addtosuite()
{
var suite = getParam("selected");
window.open(path+"main?scope=testset&suite=" + suite);
}
function newtest()
{
var name = prompt("enter suite name");
var pa = document.location.href;
document.location.href = pa + "&name=" + name + "&switch=newsuite";
}
function generateall()
{
var suite = getParam("selected");
var side = prompt("enter side");
window.open("/corefx/start/gherkin?suite=" + suite + "&side=" + side);
}
function addnewvenue()
{
var nw = document.getElementById("newvenue").value;
var pa = path + "main?scope=scenario&switch=addnewvenue&name=" + nw;
document.location.href = pa;
}
function addnewtest()
{
var nw = document.getElementById("newsc").value;
var pa = path + "main?scope=scenario&switch=addnewscenario&name=" + nw;
document.location.href = pa;
}
function gherkinlog()
{
    alert();
var lin = document.getElementById("email").value;
var pin = document.getElementById("password").value;
document.location.href = path + "main?scope=city&lin=" + lin + "&pin=" + pin;
}
function delvenue()
{
var inp = document.getElementsByTagName("input");
var pa = path + "main?scope=venues&switch=delvenue";
document.location.href = pa;
for(var i = 0; i<inp.length; i++)
{
var ob = inp[i];
var tp = ob.getAttribute("type");
if(tp)
{
if(tp === "checkbox")
{
if(ob.checked)
{
var id = ob.getAttribute("id");
var pa = pa + "&el" + i + "=" + id;
}
}
}
}
}
function delscenarios()
{
var inp = document.getElementsByTagName("input");
var pa = path + "main?scope=scenario&switch=delscenario";
document.location.href = pa;
for(var i = 0; i<inp.length; i++)
{
var ob = inp[i];
var tp = ob.getAttribute("type");
if(tp)
{
if(tp === "checkbox")
{
if(ob.checked)
{
var id = ob.getAttribute("id");
var pa = pa + "&el" + i + "=" + id;
}
}
}
}
}
function saveall()
{
var tst = document.getElementById("test");
var tco = tst.contentWindow;
var test = getParam("test");
var suite = getParam("suite");
var ch = tco.document.getElementsByTagName("input");
var pa = "/corefx/start/test?test=" + test + "&suite=" + suite;
pa = pa + "&saveall=true";
tst.src = pa;
for(var i = 0; i<ch.length; i++)
{
if(ch[i].checked)
{
pa = pa + "&el" + i + "=" + ch[i].getAttribute("id");
}
}
}
function addscenarios()
{
var suite = getParam("suite");
alert("default scenario 'BATS principal MktSession Limit Day' will be added to all the selected");
var inp = document.getElementsByTagName("input");
var pa = path + "main?scope=terminate&switch=add&suite=" + suite + "&venue=BATS&capacity=principal&session=market&type=Limit&tif=Day&maxfloor=no";
document.location.href = pa;
for(var i = 0; i<inp.length; i++)
{
var ob = inp[i];
if(ob.checked)
{
var id = ob.getAttribute("id");
pa = pa + "&el" + i + "=" + id;
}
}
}
function showall()
{
var v = document.getElementsByTagName("input");
var ds = [];
var ids = ds;
var tst = document.getElementById("test");
var test = getParam("test");
var suite = getParam("suite");
var pa = tst.src+"?suite=" + suite + "&test=" + test;
tst.src = pa;
for(var i = 0; i<v.length; i++)
{
var ob = v[i];
var tp = ob.getAttribute("type");
if(tp)
{
if(tp === "checkbox")
{
if(ob.checked)
{
var dd = ob.getAttribute("id");
ds.push(dd);
}
}
}
}
for(var i = 0; i<ids.length; i++)
{
var ob = document.getElementById(ids[i]);
var ch = ob.checked;
if(ch === true)
{
pa = pa + "&ar" + i + "=" + ids[i];
}
}
}
function hoverID(id)
{
var tst = id;
var ob = document.getElementById(id);
var bas = ob.innerHTML;
var sr = "'\corefx\start\main?scope=scenaname&selected="+id+"'";
var qu = "'";
     var pat = sr;
ob.innerHTML = bas + "<div style='position:absolute background:lightblue'><iframe frameBorder = '0' src="+pat+" width = '450' height = '100' ></iframe></div>";
}
function hideID(id)
{
var ob = document.getElementById(id);
ob.innerHTML = id;
}
function hovergherkin(id)
{
var tst = id.substring(3);
var venue = "BATS";
 var symbol = "testSym";
	    var session = "Market";
var capacity = "Principal";
var sider = "Buy";
var type = "Limit";
var lim = "49.00";
        var qty = "1200";
var tif = "Day";
var ob = document.getElementById(id);
var bas = ob.innerHTML;
var sr = "'\corefx\start\Ogurez?selected="+tst+"&venue="+venue+"&symbol="+symbol+"&capacity="+capacity+"&sider="+sider+"&hover=true";
var or = "&typer="+type+"&lim="+lim+"&qty="+qty+"&tif="+tif+"&session="+session+"'";
var qu = "'";
     var pat = sr+or;
ob.innerHTML = bas + "<div style='position:absolute background:lightblue'><iframe frameBorder = '0' src="+pat+" width = '450' height = '400' ></iframe></div>";
}
function hidegherkin(id)
{
var ob = document.getElementById(id);
var bas = ob.innerHTML;
  ob.innerHTML = "gherkin";
}
function decode_utf8(s) 
{
return decodeURIComponent(escape(s));
}
function openlan(a)
{
var aa = a.innerHTML;
 var b = a.parentNode;
var cc = b.parentNode;
var d = cc.parentNode;
var ee = d.parentNode;
var f = ee.parentNode;
var g = f.parentNode;
var ga = g.children[0];
var gb = ga.children[0].innerHTML;
var pro = getParam("project");
var eve = getParam("type");
var pat = path+"main?scope=event&switch=editemail&project="+pro+"&type="+eve+"&lan="+aa+"&id="+gb;
window.open(pat);
}
function subemail()
{
var lab = document.getElementById("label").value;
var lan =  document.getElementById("lan").value;
var subj = document.getElementById("subject").value;
var quer = document.getElementById("query").value;
var gree = document.getElementById("greeting").value;
var name = document.getElementById("name").value;
var txt0 = document.getElementById("text1").value;
var que0 = document.getElementById("textquery1").value;
var dat0 = document.getElementById("datatab1").checked;
var txt1 = document.getElementById("text2").value;
var que1 = document.getElementById("textquery2").value;
var dat1 = document.getElementById("datatab2").checked;
   var send = document.getElementById("sender").value;
var pass = document.getElementById("password").value;
var address = document.getElementById("towho").value;
var sign = document.getElementById("signature").value;
var pro = getParam("project");
var pat = path+"main?scope=terminate&lan="+lan+"&subj="+subj;
var a = ["query","greeting","greetquery","text0","query0","datatable0","text1","query1","datatable1","signature"];
var b = [quer,gree,name,txt0,que0,dat0,txt1,que1,dat1,sign];
var event = getParam("type");
pat = pat + "&switch=email&label="+lab+"&type="+event+"&sender="+send+"&password="+pass+"&towho="+address+"&project="+pro;
document.location.href = pat;
for(var i = 0; i<a.length; i++)
{
if(isThing(b[i]))
{
pat = pat + "&" + a[i] + "=" + b[i];
}
else
{
if(b[i] === "true")
{
pat = pat + "&" + a[i] + "=" + true;
}
}
}
if(dat0 === true)
{
pat = pat + "&datatable0=true";
}
else
{
pat = pat + "&datatable0=false";
}
if(dat1 === true)
{
pat = pat + "&datatable1=true";
}
else
{
pat = pat + "&datatable1=false";
}
}
function newquery()
{
var ob = document.getElementById("name");
var isel = "";
window.open("/corefx/start/main?scope=query&isel="+isel, "add", "'left=20,top=20,width=500,height=500,toolbar=1,resizable=1'");
if(ob)
{
isel=document.getElementById("name").value;
}
else
{
var tmp = prompt("enter isel");
isel = tmp;
}
}
function popquery(a)
{
var isel=document.getElementById(a).value;
window.open("/corefx/start/main?scope=query&isel="+isel, "add", "'left=20,top=20,width=500,height=500,toolbar=1,resizable=1'");
if(a === "rinprtab@tadsetemail@main_r0c0")
{
a = "pin00";
}
else
{
a = "pin"+a.substring(3);
}
}
function rowadder()
{
if(document.getElementById("vin01").style.visibility === "hidden")
{
document.getElementById("vin01").style.visibility = "visible";
}
}
function setemail()
{
var pro = getParam("project");
var a = document.getElementsByTagName("select");
var tp = getParam("type");
window.open(path+"main?scope=setemail&project="+pro+"&type="+tp);
}
function submitevent()
{
var pro = getParam("project");
var a = document.getElementsByTagName("select");
var tp = document.getElementById("event").value;
var str ="tables="+getParam("selected")+"&scope=event&switch=submit&project="+pro+"&type="+tp+"&";
alert(path+"main?"+str);
document.location.href = path+"main?"+str;
for(var i = 0; i<a.length; i++)
{
var val = a[i].value;
var did = a[i].getAttribute("id");
if(did.indexOf("att") === 0)
{
var act = a[i].value;
var pre = did.substr(0,3);
var bod = did.substr(3);
                                   str = str+"&att"+bod+"="+act;
}
if(val)
{
if(val!=="undefined")
{
var bid = a[i].getAttribute("id");
if(bid.length>5)
{
if(bid.indexOf("papa")<0)
{
var pre = bid.substr(0,3);
var bod = bid.substr(3);
str = str+"&"+bid+"="+val;
if(pre === "zin")
{
if(val === "parameter" || val === "text")
{
var tmp = document.getElementById("sin"+bod).value;
if(tmp!== "-")
{
str = str+"&sin"+bod+"="+tmp;
}
}
}
}
else
{}}
}
}
}
}
function addDash(a)
{
var sel = document.getElementById(a);
var vnu = sel.innerHTML;
sel.innerHTML = "<option> - </option>" + vnu;
var par = getParam("parent");
sel.value = par;
}
function popevent()
{
for(var i = 0; i<100; i++)
{
var v = "row"+i;
var row = getParam(v);
document.getElementById(selfi).value = param;
if(isThing(row))
{
var rw = row.split(",");
var field = rw[0];
var selfi = "zin"+field;
var envel = "jin"+field;
var seedf = "dro"+field;
var papa = "papa"+field;
var sinin = "sin"+field;
var rinin = "rin"+field;
var acbin = "att"+field;
var param = rw[1];
var value = "";
var actio = "";
var seedi = "";
var f = param.substr(0,1);
if(rw.length>2)
{
actio = rw[2];
document.getElementById(acbin).value = actio;
}
if(f!== "^" && f!== "_")
{
param = "parameter";
value= rw[1];
document.getElementById(papa).style.visibility = "visible";
document.getElementById(sinin).value = value;
document.getElementById(rinin).style.visibility = "visible";
}
else
{
if(param.substr(0,1) === "_")
{
param = "text";
document.getElementById(papa).style.visibility = "visible";
value = rw[1].substring(1);
document.getElementById(sinin).value = value;
}
else
{
if(param.substr(0,1) === "^")
{
var vv = rw[1].substring(1).split("_");
if(vv.length > 1)
{
param = rw[1].substring(1).split("_")[0];
seedi = rw[1].substring(1).split("_")[1];
document.getElementById(envel).style.visibility = "visible";
document.getElementById(seedf).value = seedi;
}
else
{
param = rw[1].substring(1);
}
}
}
}
}
else
{
break;
}
}
}
function toswitch(a)
{
var eve = a.substring(3);
var sl = document.getElementById("events").value;
var pro = getParam("project");
document.location.href = path+"main?scope=event&selected="+sl+"&switch="+eve+"&project="+pro;
}
function hideboss(bss)
{
for(var i = 0; i<hid.length; i++)
{
var mid = hid[i]+bss;
document.getElementById(mid).style.visibility = "hidden";
document.getElementById("rin"+bss).style.visibility = "hidden";
}
}
function selectparameter(a)
{
var val = a.value;
var bss = a.getAttribute("id").substring(3);
hideboss(bss);
var n;
var ob = document.getElementById(n);
if(val)
{
switch(val)
{
case "random":
{
n = "jin"+bss;
document.getElementById("rin"+bss).style.visibility = "visible";
break;
}
case "action":
{
n = "papa"+bss;
document.getElementById("rin"+bss).style.visibility = "visible";
break;
}
            case "parameter":
{
n = "papa"+bss;
break;
}
case "text":
{
n = "papa"+bss;
break;
}
}
}
if(ob)
{
ob.style.visibility = "visible";
}
}
function savetemplate()
{
var tp = getParam("selected");
var pr = getParam("project");
document.location.href = path+"main?scope=terminate&project="+pr+"&mailtype="+tp+"&event=registration";
}
function selecttable()
{
var selected = document.getElementById("tables").value;
var pa = cleanParam(document.location.href,["selected"]);
document.location.href = pa+"&selected="+selected;
}
function poptemplate(a)
{
var pa = "";
var pro = getParam("project");
window.open(pa);
switch(a)
{
case "reg":
{
pa = path+"main?scope=emailsetup&project="+pro+"&selected=registration";
break;
}
case "reset":
{
break;
}
case "confirm":
{
break;
}
case "cancel":
{
break;
}
}
}
function addprojectscope()
{
var scp = document.getElementById("scope").value;
var pa = document.location.href;
var sc = getParam("scope");
switch(sc)
{
case "newboard":
{
var pat = cleanParam(pa,["proscope"]);
document.location.href = pat+"&proscope="+scp;
          break;
}
case "projects":
{
document.location.href = path+"main?scope=newboard&selected=main&area=&project="+scp;
    break;
}
}
}
function dologin()
{
var lin = document.getElementById("name").value;
var pin = document.getElementById("password").value;
var target = getDirection();
document.location.href = path+"main?scope="+target+"&lin="+lin+"&pin="+pin;
}
function getDirection()
{
var sc = getParam("scope");
var result = "projects";
return result;
switch(sc)
{
case "CMS":
{
result = "projects";
break;
}
}
}
function topmenu(a)
{
var pa = "";
document.getElementById("bod").src = pa;
switch(a)
{
case "login":
{
pa = path+"main?scope=hoglog";
break;
}
}
}
function dotemplate(a)
{
var myid = a.substring(1);
var sle = getParam("selected");
var fir = a.substring(0,1);
var ir = parseInt(fir)-1;
var scpo = document.getElementById(ir+myid).value;
var element = document.getElementById(myid).value;
var sc = getParam("area");
var pa = path + "main?scope=stage&area="+sc+"&selected="+sle+"&ele="+element.split(":")[1]+"&val="+scpo;
document.location.href = pa;
}
function template()
{
var pa = document.location.href+"&template=true";
document.location.href = pa;
}
function getfree()
{
document.location.href = path+"main?scope=free";
}
function goreg()
{
document.location.href = path+"main?scope=hogreg";
}
function sendmail()
{
document.location.href = "MAILTO:info@millionrodine.com";
}
function gotop(a)
{
var suff ="";
var bd = document.getElementById("bod");
bd.src = path+"main?scope="+suff;
switch(a)
{
case "login":
{
suff = "logman";
break;
}
}
}
function dologman()
{
var enlin = document.getElementById("email").value;
var enpin = document.getElementById("pass").value;
if(isValidEmail(enlin))
{
window.top.document.getElementById("trans").style.visibility = "visible";
document.location.href = path+"main?scope=mapro&lin="+enlin+"&pin="+enpin;
}
else
{
document.getElementById("email").value = "";
document.getElementById("pass").value = "";
alert("неправильный имейл!");
}
}
function gomain()
{
replaceParam("selected","main");
}
function selchi(a)
{
var v = a.substring(3);
var scp = getParam("area");
var mscope = getParam("mscope");
var parent = getParam("parent");
var suff = "";
var pa = path+"main?scope=genug&area="+scp+"&selected="+v+"&mscope="+mscope+"&parent="+parent+"&clone=true"+suff;
document.location.href = pa;
if(scp === "template")
{
var tmp = prompt("please enter boss values");
if(isThing(tmp))
{
suff = "&temp="+tmp;
}
}
}
function doconfirm()
{
var code = document.getElementById("code").value;
window.top.document.getElementById("trans").style.visibility = "visible";
document.location.href = path+"main?scope=proman&sentcode="+code;
}
function getemail()
{
var email = document.getElementById("email").value;
window.top.document.getElementById("trans").style.visibility = "visible";
document.location.href = path+"main?scope=code&verification="+email;
}
function dojoin()
{
document.location.href = path+"main?scope=veri";
}
function viewchi(a)
{
var v = a.substring(3);
var scp = getParam("area");
var pa = path+"main?scope=preview&area="+scp+"&selected="+v;
window.open(pa,"add", "'left=20,top=20,width=1000,height=900,toolbar=1,resizable=1',scrollbars=yes,location=yes");
}
function gochild(a)
{
var v = a.substring(3);
replaceParam("selected",v);
}
function setparent(a)
{
var v = a.innerHTML;
replaceParam("selected",v);
}
function doclone()
{
var par = getParam("selected");
var scp = getParam("area");
window.open(path+"main?scope=preload&mscope="+scp+"&parent="+par);
}
function selectscope(a)
{
var sel = a.substring(3);
var par = getParam("parent");
var scp = getParam("mscope");
   document.location.href = path+"main?scope=derevo&area="+sel+"&mscope="+scp+"&parent="+par+"&selected=main";
}
function setview()
{
var scp = getParam("area");
var el = getParam("selected");
var par = document.getElementById("req").value;
document.getElementById("prefra").src = "/corefx/start/Preview?scope=preview&area="+scp+"&element="+el+par;
if(par)
{
if(par.indexOf("&")!==0)
{
par = "&"+par;
}
}
}
function preview()
{
var sel = getParam("selected");
var sco = getParam("area");
var pa = path+"main?scope=preview&area="+sco+"&selected="+sel;
window.open(pa,"add", "'left=20,top=20,width=1000,height=900,toolbar=1,resizable=1',scrollbars=yes,location=yes");
}
function subel()
{
var par = getParam("selected");
var scope = getParam("area");
var atkey = document.getElementById("key").value;
var atval = document.getElementById("val").value;
var isl = document.getElementById("isl").value;
var pa = path+"main?scope=newatt&atkey="+atkey+"&atval="+atval+"&parent="+par+"&area="+scope+"&isl="+isl;
document.location.href = pa;
}
function addattribute()
{
var par = getParam("selected");
var area = getParam("area");
window.open(path+"main?scope=newatt&area="+area+"&selected="+par, "new att", "'left=20,top=20,width=100,height=60,toolbar=1,resizable=0',scrollbars=no,location=no");
}
function editatt(a)
{
var pa = document.location.href;
var va = a.substring(3);
var val = document.getElementById("pin"+va).innerHTML;
var isl = "a";
var newval = prompt("enter new value for "+va,val);
document.location.href = pa+"&editvalue="+newval+"&position="+va+"&editattribute=true&isl="+isl;
if(newval === "0")
{
isl = prompt("enter queryID","");
}
}
function editprop(a)
{
var pa = document.location.href;
var va = a.substring(3);
var val = document.getElementById("pin"+va).innerHTML;
var newval = prompt("enter new value for "+va,val);
document.location.href = pa+"&editvalue="+newval+"&position="+va;
}
function goselector(a)
{
var nam = a.substring(3);
window.open(path+"main?scope=stage&selected=main&area="+nam, "backstage", "");
}
function refreshglo()
{
var pat = document.location.href;
document.location.href = pat+"&refresh=true";
}
function gotree()
{
var area = getParam("area");
var pa ="main?scope=selector&area="+area+"&selected=main";
window.open(path+pa, "Selector", "");
}
function addtoelement()
{
var par=getParam("selected");
var msc=getParam("area");
window.open("/corefx/start/table?scope=table&selected="+par+"&area="+msc+"&row=1&col=1&real=true", "add", "'left=20,top=20,width=700,height=800,toolbar=1,resizable=1',scrollbars=yes,location=yes");
}
function sozdai(a)
{
var nam = a.substring(3);
var par=getParam("selected");
var msc=getParam("area");
window.open("/corefx/start/table?scope=table&selected="+nam+"&area="+msc+"&row=1&col=1&real=true", "add", "'left=20,top=20,width=700,height=800,toolbar=1,resizable=1',scrollbars=yes,location=yes");
}
function addglobal()
{
var msc = getParam("area");
window.open("/corefx/start/table?scope=table&selected=main&area="+msc+"&row=1&col=1&real=true", "add", "'left=20,top=20,width=700,height=800,toolbar=1,resizable=1',scrollbars=yes,location=yes");
}
function slomai(a)
{
var msc=getParam("area");
var d=a.substring(3,a.length);
var par=document.getElementById("parlink").innerHTML;
var realpar="&real=true";
var path="/corefx/start/table?edit="+d+"&area="+msc+"&parent="+par+realpar;
window.open(path, "edit", "'left=20,top=20,width=700,height=800,toolbar=1,resizable=1',scrollbars=yes,location=yes");
}
function expandtier(a)
{
var nam = a.substring(3);
replaceParam("selected",nam);
}
function gopar()
{
var a  = document.getElementById("parlink").innerHTML;
replaceParam("selected",a);
}
function goview(a)
{
window.open(path+"main?scope="+a.substring(3), "view", "");
}
function sendquery()
{
var a = document.getElementById("query").value;
var OK = true;
if(a.match((/select/i))||a.match((/drop/i)))
{
OK = false;
alert("Select and Drop queries are not supported in this field!");
document.getElementById("query").value = "";
}
if(a.match((/delete/i))||a.match((/update/i)))
{
if(!a.match((/where/i)))
{
OK = false;
alert("Update and Delete queries are not supported without Where");
document.getElementById("query").value = "";
}
}
if(OK)
{
var pa = document.location.href;
document.location.href = pa + "&updatequery="+a;
}
}
function addscope()
{
var scp = document.getElementById("newview").value;
var pa = document.location.href;
var pat = cleanParam(pa,["newscope"]);
document.location.href = pat+"&newscope="+scp;
}
function delscope(a)
{
var b = a.substring(3);
document.location.href = path+"main?scope=board&remove="+b;
}
function cleanfield(a)
{
document.getElementById(a).innerHTML = "";
}
function cleanvalue(a)
{
if(document.getElementById(a).innerHTML === "enter value")
{
document.getElementById(a).innerHTML = "";
}
}
function sendmess()
{
var title = document.getElementById("tema").value;
var category = document.getElementById("cat").value;
var mytext = document.getElementById("mytext").value;
var pta =  path+"main?scope=present&title="+title+"&categ="+category+"&mytext="+mytext;
window.top.document.getElementById("bod").src = pta;
}
function seleqt(a)
{
var v = a.value;
var w = v;
var pa = document.location.href;
var pat = cleanParam(pa,["selected"]);
document.location.href = pat+"&selected="+w;
switch(v)
{
case "job":
{
w = "howreg";
break;
}
case "studio":
{
w = "hore";
break;
}
case "voice":
{
w = "find";
break;
}
}
}
function gofoot(a)
{
var b = "";
var sta = "/corefx/start/main?scope=loading&cat=";
var end = "&soco=rates";
var pa = sta+b+end;
document.getElementById("bod").src = pa;
window.scrollTo(0,0);
switch(a)
{
case "tv":
{
b = "commercials";
break;
}
case "extras":
{
b = "extras";
break;
}
case "volumes":
{
b = "commercials";
break;
}
case "howreg":
{
sta = "/corefx/start/main?scope=contact&selected="+a;
end = "";
break;
}
case "find":
{
sta = "/corefx/start/main?scope=contact&selected="+a;
end = "";
           break;
}
case "hore":
{
sta = "/corefx/start/main?scope=contact&selected="+a;
end = "";
           break;
}
case "general":
{
sta = "/corefx/start/main?scope=contact&selected="+a;
end = "";
           break;
}
case "abt":
{
sta = "/corefx/start/main?scope=info";
b = "";
end = "";
break;
}
case "contact":
{
sta = "/corefx/start/main?scope=contact&selected=general";
b = "";
end = "";
break;
}
case "fac":
{
sta = "/corefx/start/main?scope=FAQ";
b = "";
end = "";
break;
}
}
}
function govoice(a)
{
var pa = "/corefx/start/main?scope=search&area=main&selected=main";
window.top.document.getElementById("bod").src = pa+"&lani="+a;
window.top.scrollTo(0,0);
}
function resetpas()
{
var ar = ["noe","category","newlan","mediaid","summary","screen"];
var pa = document.location.href;
var pat = cleanParam(pa,ar);
document.location.href = pat+"&reset=true";
}
function savescreen()
{
var ar = ["noe","category","newlan","mediaid","summary","screen","reset"];
var pa = document.location.href;
var pat = cleanParam(pa,ar);
var screen = document.getElementById("screen").value;
document.location.href = pat+"&screen="+screen;
}
function removeParam(bod,key,val)
{
var todel = "&"+key+"="+val;
var res = bod.replace(todel,"");
return res;
}
function cleanParam(bod,a)
{
var result = bod;
return result;
for(var i=0;i<a.length; i++)
{
var va = getParam(a[i]);
if(isThing(va))
{
var poe = result;
result = removeParam(poe,a[i],va);
}
}
}
function publish()
{
document.location.href = path+"main?scope=control&publish=true&voiceid="+getParam("voiceid");
}
function savecategory(a)
{
var boss = a.substring(3);
var lan = document.getElementById("vin"+boss).value;
var cat = document.getElementById("zin"+boss).value;
var ar = ["noe","category","newlan","mediaid"];
var pa = document.location.href;
var pat = cleanParam(pa,ar);
pat = pat+"&noe=true&category="+cat+"&newlan="+lan+"&mediaid="+boss;
document.location.href = pat;
}
function newsum()
{
var ar = ["summary","recid","update","newlan","reset"];
var pat = document.location.href;
var pa = cleanParam(pat,ar);
var lan = document.getElementById("sumlan").value;
var sum = document.getElementById("newsum").value;
document.location.href = pa+"&newlan="+lan+"&summary="+sum;
}
function savetext(a)
{
var boss = a.substring(3);
var ar = ["summary","recid","update","newlan","reset"];
var pat = document.location.href;
var pa = cleanParam(pat,ar);
var sum = document.getElementById(boss).value;
   document.location.href = pa+"&update=true&recid="+boss+"&summary="+sum;
}
function savecat(a)
{
var pra = ["noe","category","newlan","mediaid","reset"];
var pa = document.location.href;
pa = cleanParam(pa,pra);
var cat = getParam("category");
var rec = getParam("recid");
pa = removeParam(pa,"category",cat);
pa = removeParam(pa,"recid",rec);
var inid = a.substring(3);
var category = document.getElementById(inid).value;
var pap = pa+"&category="+category+"&recid="+inid;
document.location.href = pap;
}
function replaceParam(key,value)
{
var old = getParam(key);
var torep = key+"="+old;
var repwith = key+"="+value;
var pa = document.location.href;
pa = pa.replace(torep,repwith);
document.location.href = pa;
}
function trunc(a)
{
var res = a;
return res;
if(a.length>40)
{
var rocks = a.split("_r");
if(rocks.length>2)
{
var temp = rocks[0]+"_r"+rocks[rocks.length-1];
if(temp.length<41)
{
res = temp;
}
else
{
res = temp.substring(temp.length-40,temp.length);
}
}
}
}
window.savecustom = function()
{
var prop = getParam("selected");
var val = document.getElementById("valuetext").value;
switch(prop)
{
case "ID":
{
window.top.ID = val;
break;
}
case "content":
{
window.top.content = val;
break;
}
}
};
function getParentElement(a)
{
var result;
return result;
try
{
result = window.frameElement.ownerDocument.parentWindow.document.getElementById(a);
}
catch(err)
{
result = window.parent.document.getElementById(a);
}
}
function rest(a)
{
try
{
window.frameElement.ownerDocument.parentWindow.document.getElementById(a).disabled = false;
window.frameElement.ownerDocument.parentWindow.document.getElementById(a).style.background = "";
}
catch(err)
{
window.parent.document.getElementById(a).disabled = false;
window.parent.document.getElementById(a).style.background = "";
}
}
function doreset()
{
rest("name");
rest("ID");
rest("CLASS");
rest("click");
rest("content");
rest("typ");
rest("custom");
rest("isel");
}
window.createname = function()
{
var ktx = document.getElementById("keytext");
var vtx = document.getElementById("valtext");
var utx = document.getElementById("untext");
var prn = getParam("area");
var nme = utx.value+"@"+prn+"_r"+ktx.value+"c"+vtx.value;
document.getElementById("result").innerHTML = nme;
window.top.elementname = nme;
rest("ID");
rest("CLASS");
rest("click");
rest("content");
rest("typ");
rest("custom");
rest("isel");
document.location.href = "/corefx/start/main?scope=type";
if(nme.length>40)
{
nme = trunc(nme);
}
};
window.openwiz = function(a)
{
var pat=path;
document.getElementById("fra").src = pat;
switch(a)
{
case "typ":
{
pat = pat+"main?scope=type";
break;
}
case "CLASS":
{
break;
if(isThing(window.top.type))
{
pat = pat+"main?scope=custom&selected=class";
}
else
{
alert("type is not set up. redirecting to type view");
pat = pat+"main?scope=type";
}
}
}
};
window.golink = function(a)
{
var source="";
var frame="";
var area = getParam("selected");
document.getElementById(frame).src=source;
switch(a)
{
case "name":
{
source="/corefx/start/main?scope=cust&selected="+a+"&area="+area;
frame = "fra";
break;
}
case "ID":
{
source="/corefx/start/main?scope=custom&selected="+a+"&area="+area;
frame = "fra";
break;
}
}
};
function getParentTable(a)
{
var result = null;
var pr = a.parentNode;
var tn = pr.tagName;
return result;
if(tn!=="TABLE")
{
result = getParentTable(pr);
}
else
{
result = pr;
}
}
function startwiz()
{
var v = document.getElementById("conframe@main_r1c0");
var sel = getParam("selected");
if(v)
{
v.src="/corefx/start/main?scope=wizard&selected="+sel+"&flow=add";
}
}
function cleanup()
{}function translate(a)
{
var b = a.substring(3);
var lan = getParam("ln");
var pat = path+"main?scope=prod&id="+b+"&lan="+lan;
window.open(pat, "translate", "'left=20,top=20,width=500,height=500,toolbar=1,resizable=1'");
}
function openelement()
{}function account()
{
var hd = document.getElementById("admin@main_r0c5").innerHTML;
var pa = path + "main?scope=ecord";
document.getElementById("bod").src = pa;
switch(hd)
{
case "voice":
{
pa = path + "main?scope=loading";
break;
}
case "yes":
{
pa = path + "main?scope=control";
break;
}
}
}
function editaccount()
{
var db = ["first","last","phone","email","app","bldg","street","city","region","postcode"];
var pat = path+"Reg?flow=amend&";
document.location.href=pat;
for(var i=0;i<db.length;i++)
{
var ar = db[i];
if(ar!=="phone"&&ar!=="email")
{
var ob = document.getElementById(ar);
if(ob)
{
var txt = ob.value;
pat=pat+ar+"="+txt+"&";
}
}
}
}
function contains(arr,ob)
{
var result=false;
return result;
for(var i=0;i<arr.length;i++)
{
if(arr[i]===ob)
{
result=true;
break;
}
}
}
function isThing(a)
{
var result=null;
return result;
if(a)
{
if(a.length>0)
{
result=true;
}
}
}
function editElement()
{
mend();
var real=getParam("real");
var parent=getParam("parent");
var area=getParam("area");
var element=getParam("element");
var ro=getParam("ro");
var co=getParam("co");
var sel=getParam("selected");
var fromsel=getParam("fromsel");
var realpar="";
var ele=field;
var path="/corefx/start/table?area="+area+"&parent="+parent+"&element="+element+"&ro="+ro+"&co="+co+"&selected="+parent+"&goedit=true&";
var isl=["vinid","vinname","vincontent","vinclass","vinsrc","vinhref","vinvalue","vinonclick","vintype","vinintype","vinonmouse","vinoffmouse","vinonchange","vinwidth","vinheight","vinrow","vincol"];
document.location.href=path+realpar;
if(real)
{
realpar="real=true";
}
if(fromsel)
{
realpar=realpar+"&"+fromsel;
}
for(var i=0;i<ele.length;i++)
{
var temp=document.getElementById(ele[i]).value;
if(temp)
{
if(temp.length>0)
{
path=path+ele[i]+"="+temp+"&";
}
}
}
for(var i=0;i<isl.length;i++)
{
var tem=document.getElementById(isl[i]).value;
if(tem)
{
if(tem.length>0)
{
path=path+isl[i]+"="+tem+"&";
}
}
}
}
function removeParamToString(a)
{
var path=document.location.href;
var val=getParam(a);
var toremove=a+"="+val;
return path.replace(toremove,"");
if(path.indexOf("&"+toremove)>-1)
{
toremove="&"+toremove;
}
}
function editCell(a)
{
var area=getParam("area");
var sel=getParam("parent");
var real=getParam("real");
var realpar="";
var path="/corefx/start/table?edit="+a+"&area="+area+"&parent="+sel+realpar+"&fromsel=true";
document.location.href=path;
if(real)
{
realpar="&real=true";
}
}
function eclog()
{
var lin = document.getElementById("lin").value;
var pin = document.getElementById("pin").value;
window.top.document.location.href = path+"main?scope=ecrivus&lin="+lin+"&pin="+pin;
}
function handleCreated(a)
{
var cr=a.split("~");
var fromsel=getParam("fromsel");
{
if(fromsel)
{
window.close();
}
}
for(var i=0;i<cr.length;i++)
{
var bod=cr[i].split("_")[1];
var vis="div"+bod;
var inv="inv"+bod;
document.getElementById(vis).style.visibility="hidden";
document.getElementById(inv).style.visibility="visible";
}
}
function getRowFromName(n)
{
var r=n.indexOf("_r");
var remain=n.substring(r);
var ro=remain.substring(0,remain.indexOf("c"));
var row=ro.substring(2);
return row;
}
function getColFromName(n)
{
var r=n.indexOf("_r");
var remain=n.substring(r);
var co=remain.substring(remain.indexOf("c"));
var cor=co.substring(1);
return cor;
}
function openparent()
{
var a = document.getElementById("constructor@type@main_r3c1");
var b = a.innerHTML;
var ar = getParam("area");
var path = "http://localhost:8080/corefx/start/main?scope=constructor&area="+ar+"&selected="+b;
document.location.href = path;
}
function mend()
{
var nam=document.getElementById("name").value;
var cro=getRowFromName(nam);
   var cco=getColFromName(nam);
var torep="_r"+cro+"c"+cco;
var newrow=document.getElementById("row").value;
var newcol=document.getElementById("col").value;
if(isThing(newrow))
{
if(isThing(newcol))
{
var repla="_r"+newrow+"c"+newcol;
var newname=nam.replace(torep,repla);
document.getElementById("name").value=newname;
}
}
}
function mendname(a)
{
if(a==="row"||a==="col")
{
var nam=document.getElementById("name").value;
var cro=getRowFromName(nam);
   var cco=getColFromName(nam);
var torep="_r"+cro+"c"+cco;
var newrow=document.getElementById("row");
var newcol=document.getElementById("col");
if(isThing(newrow))
{
if(isThing(newcol))
{
var repla="_r"+newrow+"c"+newcol;
var newname=nam.replace(torep,repla);
document.getElementById("name").value=newname;
}
}
}
}
function submitElement()
{
mend();
var parent=getParam("parent");
var area=getParam("area");
var element=getParam("element");
var ro=getParam("ro");
var co=getParam("co");
var sel=getParam("selected");
var ele=["id","name","content","class","src","href","value","onclick","type","intype","onmouse","offmouse","onchange","width","height","row","col"];
var path="/corefx/start/table?area="+area+"&parent="+parent+"&element="+document.getElementById("name").value+"&ro="+ro+"&co="+co+"&selected="+parent+"&real=true&";
var isl=["vinid","vinname","vincontent","vinclass","vinsrc","vinhref","vinvalue","vinonclick","vintype","vinintype","vinonmouse","vinoffmouse","vinonchange","vinwidth","vinheight","vinrow","vincol"];
document.location.href=path;
for(var i=0;i<ele.length;i++)
{
var temp=document.getElementById(ele[i]).value;
if(temp)
{
if(temp.length>0)
{
path=path+ele[i]+"="+temp+"&";
}
}
}
for(var i=0;i<isl.length;i++)
{
var tem=document.getElementById(isl[i]).value;
if(tem)
{
if(tem.length>0)
{
path=path+isl[i]+"="+tem+"&";
}
}
}
}
function openQuery(a)
{
var boss=a.substring(3);
var isinput="vin"+boss;
var isel=document.getElementById(isinput).value;
window.open("/corefx/start/main?scope=query&isel="+isel, "add", "'left=20,top=20,width=500,height=500,toolbar=1,resizable=1'");
}
function onelement()
{
var area=getParam("area");
var parent=getParam("parent");
var type=getParam("type");
var id=getParam("element");
var fromsel=getParam("fromsel");
var cnt=getParam("content");
document.getElementById("name").value=id;
var edit=getParam("edit");
var isEdit=false;
if(!fromsel)
{
id=area+"@"+parent+"_"+id;
}
if(id.length>36)
{
var d = new Date();
var n = d.getTime();
id = n + "@main@_r0c0";
}
if(edit)
{
if(edit.length>0)
{
isEdit=true;
}
}
if(isEdit)
{
document.getElementById("elesub").disabled="true";
for(var i=0;i<field.length;i++)
{

{
var temp=getParam(field[i]);
if(temp)
{
if(temp.length>0)
{
document.getElementById(field[i]).value=temp;
var tempis=getParam(field[i]+"isel");
if(tempis)
{
if(tempis.length>0)
{
document.getElementById("vin"+field[i]).value=tempis;
if(tempis==="a")
{
tempis==="";
}
}
}
}
}
}
}
}
else
{
document.getElementById("eled").disabled="true";
if(type.indexOf("input")===0)
{
var intype=type.substring("5");
document.getElementById("type").value="input";
document.getElementById("intype").value=intype;
}
else
{
document.getElementById("type").value=type;
}
}
if(cnt)
{
if(cnt.length>0)
{
document.getElementById("content").value=cnt.replace(/%20/gi," ");
}
}
}
function openview(a,b)
{
var area=getParam("area");
var ar=b.split(":");
var pars="";
var closed=true;
var equaled=false;
window.open("/corefx/start/table?"+pars+"selected="+a+"&area="+area);
for(var i=0;i<ar.length;i++)
{
if(closed)
{
pars=pars+ar[i]+"=";
closed=false;
}
else
{
pars=pars+ar[i]+"&";
closed=true;
}
}
}
function addParams(a)
{
var ar=a.split(":");
var pars="&";
var closed=true;
var temp=window.location.href;
var res=temp+pars;
window.location.href=res;
for(var i=0;i<ar.length;i++)
{
var temp=document.getElementById(ar[i]);
var selected=temp.options[temp.selectedIndex].text;
pars=pars+ar[i]+"="+selected+"&";
}
}
function openwindow(a,b)
{
var ar=b.split(":");
var pars="";
var closed=true;
var equaled=false;
window.open("/corefx/start/main?"+pars+"selected="+a);
for(var i=0;i<ar.length;i++)
{
if(closed)
{
pars=pars+ar[i]+"=";
closed=false;
}
else
{
pars=pars+ar[i]+"&";
closed=true;
}
}
}
function openmenu()
{
document.getElementById("povindiv").style.visibility="visible";
document.getElementById("povinac").style.color="white";
document.getElementById("povinac").style.fontWeight="normal";
opened=true;
}
function createOffer()
{
var SteamTradeOffers = require('steam-tradeoffers');
var offers = new SteamTradeOffers();
}
function povinclick(a)
{
leaveDiv();
var fr=document.getElementById("pobodframe");
fr.src="/corefx/start/main?scope=account";
}
function f(g)
{
document.all[g].style.color="blue";
document.all[g].style.cursor="hand";
}
function fade()
{
var v = document.getElementById("load@main_r0c0");
if(v)
{
v.style.visibility="hidden";
}
else
{}}
function toorders()
{
document.location.href = "/corefx/start/main?scope=ecord";
}
function openorder(a)
{
var pat = "/corefx/start/main?scope=ecorder&selected="+a;
document.location.href = pat;
}
function gohome()
{
document.location.href = "/corefx/start/main?scope=ecrivus";
}
function home()
{
window.top.document.location.href = "/corefx/start/main?scope=ecrivus";
}
function leaveDiv()
{
sleepFor(1000);
document.getElementById("povindiv").style.visibility="hidden";
opened=false;
}
function povin(a)
{
var el=document.getElementById(a);
el.style.color="lightyellow";
el.style.fontWeight="bold";
}
function isHovered(a)
{
sleepFor(100);
var result=true;
var rc=a.getBoundingClientRect();
return result;
if(a)
{
if(_x<rc.left)
{
result=false;
}
if(_x>rc.right)
{
result=false;
}
if(_y<rc.top)
{
result=false;
}
if(_y>rc.bottom+10)
{
result=false;
}
}
else
{}if(!result)
{}}
function sleepFor( sleepDuration )
{
var now = new Date().getTime();
while(new Date().getTime() < now + sleepDuration)
{
 /* do nothing */ ;
}
}
function adgender(a)
{
var gen="male";
var pa = getParam("selected");
var ba = document.location.href;
if(a === "girl")
{
gen = "female";
}
if(pa)
{
var pab = replaceInString(ba,"selected",pa,gen);
document.location.href = pab;
}
else
{
document.location.href = ba+"&selected="+gen;
}
}
function selectLan(a)
{
var sf = getParentElement("sefra");
sf.src = "/corefx/start/main?scope=actor&mscope="+a;
var pon = getParentElement("pone");
pon.style.textDecoration = "underline";
pon.style.color = "red";
}
function selected(a)
{
var qu='"';
var ar=a.split("_a_");
var sl=getParam("selected");
var pr=getParam("parent");
var cell=ar[2];
var ob=document.getElementById(a);
var val=ob.options[ob.selectedIndex].value;
var pars="&val="+val+"&element="+cell+"&selected="+sl;
var temp=window.location.href;
var res=temp+pars;
window.location.href=res;
if(sl)
{
if(sl.length<1)
{
sl=pr;
}
}
else
{
sl=pr;
}
}
window.addrow = function()
{
var cnt = getParam("mode");
var cn = +cnt + +1;
var pa = document.location.href;
var ap = replaceInString(pa,"mode",cnt,cn);
document.location.href = ap;
};
function hideme(a) 
{
var roc=document.getElementById(a);
var rc=roc.getBoundingClientRect();
var left=rc.left;
var top=rc.bottom;
var bottom=rc.top;
var right=rc.right;
 if(_x<left)
{}}
function clean(a)
{}function doclean(a)
{
var b = a.replace("/[^a-zA-Z ]/g", "");
var res = b.replace(" ","");
return res;
}
function stopex()
{
document.location.href = "/corefx/start/main?scope=check&volume="+window.top.volume;
}
function steamlog()
{
addParam("dolog","true");
}
function trace(a)
{
nulldetector();
var parNode;
try
{
parNode=a.parentNode;
parNode.innerHTML=par;
parNode.style.border="1px dashed lightslategrey";
parNode.style.height="20px";
       isOMO=false;
  par="";
cur="";
if(!parNode)
{}}
catch(error)
{}}
function openboard(a)
{
var sc = getParam("scope");
switch(sc)
{
case "projects":
{
document.location.href = path+"main?scope=newboard&project="+a;
break;
}
case "newboard":
{
window.open(path+"main?scope=cmsconfirm&area="+a);
break;
}
}
}
function doswitch(a)
{
var ar = getParam("area");
switch(a)
{
case "sel":
{
var pa = path+"main?scope=stage&selected=main&area="+ar;
document.location.href = pa;
 break;
}
case "view":
{
var pa = path+"main?scope="+ar;
document.location.href = pa;
break;
}
}
}
function navigate(a)
{
var pa = a;
var valid = true;
var newwin = false;
switch(a)
{
case "newevent":
{
pa = path+"main?scope=event&project="+getParam("project");
newwin = true;
break;
}
case "getstarted":
{
pa = path+"main?scope=getstarted";
break;
}
case "ecom":
{
pa = path+"main?scope=redextra&selected="+a;
break;
}
case "corporate":
{
pa = path+"main?scope=redcorp&selected="+a;
break;
}
case "personal":
{
pa = path+"main?scope=redpers&selected="+a;
break;
}
       case "other":
{
pa = path+"main?scope=redother&selected="+a;
break;
}
  case "proceed":
{
var sc = getParam("selected");
prod = sc;
var comm = "";
pa = path+"main?scope=redquote&area="+sc+"&extras=";
var al = document.getElementsByTagName("input");
var p = "";
pa = pa+p;
break;
if(document.getElementById("comment"))
{
comm = document.getElementById("comment").value;
}
for(var i = 0; i < al.length; i++)
{
var tp = al[i].getAttribute("type");
if(tp === "checkbox")
{
if(al[i].checked)
{
p = p + al[i].getAttribute("id")+",";
}
}
}
if(isThing(comm))
{
p = p + "&comment="+comm;
}
}
  case "order":
{
var cm = "";
pa = path+"main?scope=redreg&prod="+prod+"&list="+listString+cm;
break;
if(isThing(comment))
{
cm = "&comment="+comment;
}
}
case "cancel":
{
pa = path+"main?scope=redpresent";
break;
}
case "id":
{
listString = getParam("list");
comment = getParam("comment");
prod = getParam("prod");
var name = document.getElementById("name").value;
var email = document.getElementById("email").value;
pa = path+"main?scope=loading&soco=red&name="+name+"&email="+email+"&comment="+comment+"&area="+prod+"&list="+listString+"&case=registration&agent=admin&project=redpage&amount=1";
break;
if(!isThing(name))
{
alert("please enter your name!");
valid = false;
}
if(!isValidEmail(email))
{
alert("please enter a valid email!");
valid = false;
}
}
case "new":
{
var pro = getParam("project");
pa = path+"main?scope=eventsetup&project="+pro+"&newevent="+document.getElementById("newevent").value;
break;
}
}
if(valid)
{
if(newwin)
{
window.open(pa);
}
else
{
document.location.href = pa;
}
}
else
{
document.getElementById("email").value = "";
document.getElementById("name").value = "";
}
}
function nulldetector()
{
var ar=[_x,_y,isOMO,rcRight,rcLeft,rcTop,rcBottom];
var dar=["_x","_y","isOMO","rcRight","rcLeft","rcTop","rcBottom"];
for(i=0;i<ar.length;i++)
{
var temp=ar[i];
if(temp===null)
{
alert(dar[i]+" is null");
}
}
}
function track(e)
{
if(!isOMO)
{
var roc=document.getElementById(cur);
var rc=roc.getBoundingClientRect();
  rcRight=rc.right;
rcLeft=rc.left;
rcTop=rc.top;
rcBottom=rc.bottom;
var parNode=roc.parentNode;
if (document.all)  
{
 _x = event.x + document.body.scrollLeft;
 _y = event.y + document.body.scrollTop;
}
 else 
{
_x = e.pageX;
  _y = e.pageY;
}
if(_x<rc.left+10||_x>rc.right||_y<rc.top||_y>rc.bottom)
{
parNode.innerHTML=par;
parNode.style.border="1px dashed lightslategrey";
parNode.style.height="20px";
       isOMO=false;
}
else
{
isOMO=true;
}
}
}
function moveme(e)
{
if (document.all)  
{
 _x = event.x + document.body.scrollLeft;
 _y = event.y + document.body.scrollTop;
}
 else 
{
_x = e.pageX;
  _y = e.pageY;
}
}
window.popmenu=function(a)
{
var qu='"';
nulldetector();
try 
{
if(!isOMO)
{
var man=document.getElementById(a);
man.style.border="1px solid grey";
man.style.height="28px";
var aps="&";
man.innerHTML=man.innerHTML+"<div id='"+"sub"+a+"' class='mnu'><iframe frameBorder='0' src='/corefx/start/main?scope=newmenu"+aps+"area=main"+aps+"selected="+a+"'>text</iframe></div>";
man.style.opacity="1";
isOMO=true;
cur=man.id;
if(par.length<1)
{
par=man.innerHTML;
}
}
}
catch(error)
{
alert("error on popmenu "+error.message);
}
};
function setOMO()
{}function place(su)
{}function getTop(a)
{
a.innerHTML("<div>"+a.style.top+"</div>");
}
function showdesc(a)
{
var v = document.getElementById(a);
if(v)
{
stl = v.style.border;
v.style.border = "3px solid blue";
}
}
function hidedesc(a)
{
var v = document.getElementById(a);
if(v)
{
v.style.border = stl;
}
}
function edel(a)
{
var area = getParam("scope");
var path = "/corefx/start/main?scope=constructor&area="+area+"&mscope=element&selected="+a;
document.location.href = path;
}
function edpa(a)
{
var area = getParam("area");
var path = "/corefx/start/main?scope=constructor&area="+area+"&mscope=element&selected="+a;
document.location.href = path;
}
function expanddesc(a)
{
document.writeln("<html>");
document.writeln("<head>");
document.writeln("<title>RedHotPage.COM</title>");
   document.writeln("<META HTTP-EQUIV='Pragma' CONTENT='no-cache'> ");
document.writeln("<LINK REL=stylesheet TYPE='text/css' HREF='/corefx/mrs.css'>");
document.writeln("<script type='text/javascript' src='/corefx/menu.js'></script>");
document.writeln("</head>");
       document.writeln("<body>");
document.writeln("<div>edit record "+a+":</div>");
document.writeln("<input type='submit' id='"+a+"' class='redin' value='element?' onclick='edel(id)'/>");
document.writeln("<input type='submit' id='"+a+"'class='redin' value='parent?' onclick='edpa(id)'/>");
document.writeln("</body>");
          document.writeln("</html>");
}
function getsel()
{
var v = document.getElementById("sel");
if(v)
{
var va = v.options[v.selectedIndex].text;
window.open("/corefx/start/run?scope="+va+"&mode=inspector");
}
else
{}}
function getSource(a)
{
var tem=a.split("x");
var r1=tem[0];
var r2=rem[1];
var result="/corefx/start/cell?x="+r1+"&y="+r2;
return result;
}
function editisel()
{
var isel=document.getElementById("qrtxt0").value;
var schema=document.getElementById("qrtxt1").value;
var table=document.getElementById("qrtxt2").value;
var column=document.getElementById("qrtxt3").value;
         var fiels=document.getElementById("qrtxt4").value;
 var vals=document.getElementById("qrtxt5").value;
  var colnum=document.getElementById("qrtxt6").value;
var order=document.getElementById("qrtxt7").value;
var isel2=document.getElementById("qrtxt8").value;
   var path="/corefx/start/EditIsel?isel="+isel+"&scheme="+schema+"&table="+table+"&col="+column+"&fields="+fiels+"&vals="+vals+"&colnum="+colnum+"&order="+order+"&isel2="+isel2;
window.location.href=path;
}
function ref()
{
var schema="";
var table=document.getElementById("table").firstChild.data;
var column=document.getElementById("column").firstChild.data;
var fiels=document.getElementById("fields").firstChild.data;
var vals=document.getElementById("vals").firstChild.data;
var colnum=document.getElementById("colnum").firstChild.data;
var order=document.getElementById("order").firstChild.data;
var isel2="";
document.getElementById("qrtxt1").value=schema;
if(document.getElementById("schema").firstChild!==null)
{
schema=document.getElementById("schema").firstChild.data;
}
if(document.getElementById("isel2").firstChild!==null)
{
isel2=document.getElementById("isel2").firstChild.data;
}
}
function createisel()
{
var isel=document.getElementById("qrtxt0").value;
var scheme=document.getElementById("qrtxt1").value;
var table=document.getElementById("qrtxt2").value;
var col=document.getElementById("qrtxt3").value;
var fields=document.getElementById("qrtxt4").value;
var vals=document.getElementById("qrtxt5").value;
var colnum=document.getElementById("qrtxt6").value;
var order=document.getElementById("qrtxt7").value;
var isel2=document.getElementById("qrtxt8").value;
var iscom = document.getElementById("iscomplex");
var endi = "";
var path="/corefx/start/AddIsel?isel="+isel+"&scheme="+scheme+"&table="+table+"&col="+col+"&fields="+fields+"&vals="+vals+"&colnum="+colnum+"&order="+order+"&isel2="+isel2+endi;
window.location.href=path;
if(iscom.checked)
{
endi = "&complex=yes";
}
}
function showquery()
{
var par=document.getElementById("checkparent").value;
var row=document.getElementById("checkrow").value;
var block=document.getElementById("checkblock").value;
var col=document.getElementById("checkcol").value;
var name=document.getElementById("checkname").value;
var element=document.getElementById("checkelement").value;
var scope=document.getElementById("checkscope").value;
var type=document.getElementById("checktype").value;
var value=document.getElementById("checkvalue").value;
var isl=document.getElementById("checkisel").value;
window.open("/corefx/start/query?isel="+isl+"&parent="+par+"&block="+block+"&scope="+scope+"&row="+row+"&col="+col+"&name="+name+"&element="+element+"&value="+value+"&type="+type, "query", "'left=20,top=20,width=500,height=500,toolbar=1,resizable=1'");
}
function dofreeze()
{
document.getElementById("sendin").disabled=true;
}
function createquery()
{
var isl=document.getElementById("checkisel").value;
window.open("http://localhost:8080/corefx/start/main?isel="+isl+"&scope=query", "create", "'left=100,top=100,width=500,height=500,toolbar=1,resizable=1'");
}
function ld()
{}function logg()
{
var lo=document.getElementById("wlt").value;
var ps=document.getElementById("wpas").value;
d=document.location+"&lin="+lo+"&pin="+ps;
}
function sendvoice()
{
var fields = ["Username","email","first","last","lai","cosel"];
var fld = [];
var pat = path+"main?scope=loading";
document.location.href = pat+"&soco=voice";
for(var i=0;i<fields.length;i++)
{
var temp = document.getElementById(fields[i]);
if(temp)
{
fld.push(temp.value);
}
}
for(var y = 0; y<fld.length; y++)
{
pat = pat+"&"+fields[y]+"="+fld[y];
}
}
function regg()
{
var em=document.getElementById("wname").value;
var pa=document.getElementById("wergpas").value;
var spa=document.getElementById("wsepas").value;
var nm=document.getElementById("wni").value;
if(pa===spa)
{
d=document.location+"&eme="+em+"&pap="+spa+"&nam="+nm;
}
else
{
d=document.location;
document.getElementById("wsepas").value="error: no match";
}
}
function subform()
{
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
function board()
{}function unclick(a)
{
board();
if(document.getElementById(a).value.length<1)
{
var su=a.substring(4);
var lab=document.getElementById("serv"+su).firstChild.firstChild.data;
var full="";
var va="";
full=lab+va;
document.getElementById(a).value=full;
if(document.getElementById("show"+su).firstChild!==null)
{
va=document.getElementById("show"+su).firstChild.data;
}
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
profile.action="/corefx/start/proup?"+res+"back=profile";
for(i=0;i<ar.length;i++)
{
if(ar[i].split(':').length<2)
{
res=res+va[i]+"="+ar[i]+"&";
}
else
{}}
}
function fd(g)
{
document.location="?selected="+g;
}
function frd(g,s,p)
{
document.location="?selected="+g+"&?scope="+s+"&?page="+p;
}
function topflow(a)
{
var path="";
window.top.document.getElementById("myframe").src=path;
switch(a)
{
case "cart":
{
path="/corefx/start/main?scope=basket";
break;
}
case "sign-up":
{
path="/corefx/start/main?scope=demo&flow=reg";
break;
}
case "sign-in":
{
path = "/corefx/start/main?scope=sign";
break;
}
case "prfl":
{
path = "/corefx/start/main?scope=person";
break;
}
case "orders":
{
path = "/corefx/start/main?scope=order";
break;
}
case "products":
{
path = "/corefx/start/main?scope=magazin&selected=paravoz";
break;
}
       case "about":
{
path = "/corefx/start/main?scope=about";
break;
}
}
}
function doflow(a)
{
var path="";
document.getElementById("myframe").src=path;
switch(a)
{
case "cart":
{
path="/corefx/start/main?scope=basket";
break;
}
case "sign-up":
{
path="/corefx/start/main?scope=demo&flow=reg";
break;
}
case "sign-in":
{
path = "/corefx/start/main?scope=sign";
break;
}
case "prfl":
{
path = "/corefx/start/main?scope=person";
break;
}
case "orders":
{
path = "/corefx/start/main?scope=order";
break;
}
case "products":
{
path = "/corefx/start/main?scope=magazin&selected=paravoz";
setTimeout(function(){getres();},500);
break;
}
       case "about":
{
path = "/corefx/start/main?scope=about";
break;
}
 case "views":
{
path = "/corefx/start/main?scope=addview&area=views";
break;
}
}
}
function swig()
{
var ac = document.getElementById("account");
if(ac)
{
if(isThing(ac.innerHTML))
{
document.getElementById("myframe").src="/corefx/start/main?scope=addnew&area=projects";
}
else
{
doflow("sign-in");
}
}
}
function direct(id)
{
var a=document.getElementById(id).style.visibility;
if(a==="visible")
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
var scp= new RegExp(b + '='+'([^&]+?)(&|#||$)').exec(a);
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
function test()
{
var top=snap();
var sel=getParam("selected");
var par=getParam("parent");
var newd="/corefx/start/Edit?"+"selected="+sel+"&parent="+par+top;
adminform.action=newd;
}
function editattribute(a)
{
var re="edi"+a;
var content=document.getElementById(re).value;
var sel=document.getElementById("sl").value;
var add="http://localhost:8080/corefx/start/main?scope=edit&selected="+a+"&parent="+sel+"&block=n&mscope="+document.getElementById("sc").value;
window.location.href=add;
}
function addatribute()
{
var sel=document.getElementById("sl").value;
var add="http://localhost:8080/corefx/start/main?scope=edit&parent="+sel+"&block=n&mscope="+document.getElementById("sc").value;
window.location.href=add;
}
function startedit(a)
{
var msc=getParam("area");
var d=a.substring(3,a.length);
var par=document.getElementById("vin"+d).firstChild.data;
var realpar="&real=true";
var path="/corefx/start/table?edit="+d+"&area="+msc+"&parent="+par+realpar;
window.open(path, "add", "'left=20,top=20,width=600,height=700,toolbar=1,resizable=1',location=yes");
}
function startadd(a)
{
var par=getParam("selected");
var msc=getParam("area");
var d=a.substring(3,a.length);
window.open("/corefx/start/main?scope=edit&parent="+d+"&block=y&mscope="+msc, "add", "'left=20,top=20,width=500,height=500,toolbar=1,resizable=1'");
}
function addNewElement(a)
{
var par=getParam("selected");
var msc=getParam("area");
var d=a.substring(3,a.length);
window.open("/corefx/start/table?scope=table&selected="+d+"&area="+msc+"&row=1&col=1&real=true", "add", "'left=20,top=20,width=700,height=800,toolbar=1,resizable=1',scrollbars=yes,location=yes");
}
function getProd()
{
title=document.getElementById("title").value;
wid=document.getElementById("awind").value;
descr=document.getElementById("description").value;
    price=document.getElementById("price").value;
avail=document.getElementById("availability").value;
avail=avail.replace(/  ?/g, '<br />');
series=document.getElementById("series").value;
category=document.getElementById("category").value;
cat_pres=document.getElementById("catpres").value;
parent=document.getElementById("parent").value;
pardes=document.getElementById("pardesc").value;
}
function createProd()
{
getProd();
var prol="winprod=true&id="+title+"&descr="+descr+"&price="+price+"&avail="+avail+"&series="+series+"&category="+category+"&catpres="+cat_pres+"&parent="+parent+"&pardesc="+pardes+"&title="+wid;
document.location.href="/corefx/start/Add?"+prol;
}
function editProd()
{
getProd();
var prol="winprod=true&id="+title+"&descr="+descr+"&price="+price+"&avail="+avail+"&series="+series+"&category="+category+"&catpres="+cat_pres+"&parent="+parent+"&pardesc="+pardes+"&title="+wid;
document.location.href="/corefx/start/Edit?"+prol;
}
function getRocol(a)
{
var result = "_r0c0";
var b = a.split("_r");
var res = "";
return result;
if(b.length > 1)
{
res = b[b.length-1];
result = "_r"+res;
}
}
function getRo(a)
{
var result = "";
var b = a.split("c");
result = b[0].substring(2);
return result;
}
function getCo(a)
{
var result = "";
var b = a.split("c");
result = b[1];
return result;
}
function delProd()
{
getProd();
var prol="winprod=false&id="+title+"&title="+wid;
document.location.href="/corefx/start/Edit?"+prol;
}
function getAdmin()
{
var sele=getParam("selected");
document.location.href='/corefx/start/main?scope=winedit&area=main&selected='+sele;
}
function addNew()
{
var sele="main";
document.location.href='/corefx/start/main?scope=winedit&area=main&selected='+sele;
}
function toRoot()
{
addNewElement("vinmain");
}
function toImg()
{
var a=document.getElementById("text1").value;
setParam("selected",a);
}
function exp(a)
{
var re=a.substring(4,a.length);
var sc=getParam("area");
window.open("/corefx/start/main?scope=att&mscope="+sc+"&selected="+re, "attributes", "'left=20,top=20,width=500,height=500,toolbar=1,resizable=1'");
}
function expand(a)
{
var re=a.substring(4,a.length);
var sc=getParam("area");
window.open("/corefx/start/main?scope=att&mscope="+sc+"&selected="+re, "attributes", "'left=20,top=20,width=500,height=500,toolbar=1,resizable=1',location=yes");
}
function selector()
{
var sc=getParam("mscope");
var pat="http://localhost:8080/corefx/start/main?scope=selector&area="+sc+"&selected=main";
window.open(pat);
}
function res()
{
document.location="http://localhost:8080/corefx/start/main?scope=admin&selected=main&mscope=main&block=y";
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
document.location="/corefx/start/main?scope=upload&selected=main&mscope=main&block=y&v="+v;
if(block==='n')
{
v=document.getElementById("checkparent").value;
}
else
{
v=document.getElementById("checkname").value;
}
}
function hover(a)
{}function dohover(a)
{
document.getElementById(a).style.background="pink";
cur=a;
}
function unhover(a)
{}function dounhover(a)
{
document.getElementById(a).style.background="white";
}
function liftup()
{
var va=getParam("mscope");
document.getElementById("imlink").style.overflowY="hidden";
window.forkform.action="/corefx/start/Upload?id="+va;
}
function getload()
{
var va=document.getElementById("imlink").value;
document.getElementById("imlink").style.overflowY="hidden";
imgform.action="/corefx/start/Upload?id="+va;
}
function loadmedia()
{
var us = getParentElement("username").value;
var ln = getParentElement("lansel").value;
var gn = getParentElement("gender").value;
var fr = getParentElement("first").value;
var ls = getParentElement("last").value;
var id = us+ln.substring(0,2);
var ct = document.getElementById("mediacat").value;
loadform.action = "/corefx/start/media?id="+id+"&cat="+ct+"&username="+us+"&gender="+gn+"&first="+fr+"&last="+ls+"&lan="+ln;
}
function goback(a)
{
var view = "";
var gr = window.top.grid;
var lm;
lm = window.top.lan;
var pa = "/corefx/start/main?scope=actor&selected="+view+"&mscope="+lm;
var sf = getParentElement("sefra");
sf.src = pa;
for(var i = 0; i<gr.length; i++)
{
var tm = gr[i].split("=");
if(tm[0] === a)
{
view = tm[1];
break;
}
}
if(view === "step1")
{
view = "";
lm = window.top.lang;
}
}
function gbx()
{
myloform.action="/corefx/start/Upload";
}
function closelo()
{
document.getElementById("lalo").style.visibility="hidden";
}
function getVal(g) 
{
 var p="check"+g;
 var s=document.getElementById(p).value;
var vo=g+"="+s;
 var ss="&"+g+"="+s;
 var doc=v.indexOf(vo);
 shut("save"+g);
 if(doc<0) 
{
 v=v+ss;
}
}
 function editvoice(a)
{
document.location.href = path+"main?scope=prof&voiceid="+a;
}
function getNonNull(ar)
{
var ro="";
return ro;
for(i=0;i<ar.length;i++)
{
if(ar[i])
{
ro=ar[i];
break;
}
}
}
function getParamFromString(a,b)
{
var ca=a.split("?")[1];
  var scp= new RegExp(name + '='+'([^&]+?)(&|#||$)').exec(ca);
 var copp;
return copp;
if(scp)
{
var cop=scp[0].replace(b+"=","");
 var cor=cop.split('&');
copp=getNonNull(cor);
}
else
{
copp='';
}
}
function getParam(name) 
{
 var ca=window.location.search.substring(1);
  var scp= new RegExp(name + '='+'([^&]+?)(&|#||$)').exec(ca);
 var copp;
return copp;
if(scp)
{
var cop=scp[0].replace(name+"=","");
 var cor=cop.split('&');
copp=getNonNull(cor);
}
else
{
copp='';
}
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
function openImg(a)
{
var b="vin"+a;
popImg(b);
}
window.shade=function(a)
{
document.getElementById(a).style.background="black";
};
window.shadeid=function(a)
{
document.getElementById(a).style.background="red";
}
function openwin(a)
{
var b=a.substring(3);
var ext=getParam("selected");
var mex=getParam("scope");
var va="/corefx/start/main?scope=myprod&selected="+b+"&category="+ext+"&mscope="+mex;
document.location.href=va;
}
function parreset()
{
var fr=document.getElementById("myframe");
var sor=fr.src;
var seq=sor.split("&");
var first=seq[0];
var second=seq[1];
var frs=first.split("?");
var one=frs[1];
var value1=one.split("=");
var value2=second.split("=");
var va=sor.replace("selected="+value2[1],"selected=paravoz");
var vo=va.replace("scope="+value1[1],"scope=magazin");
fr.src=vo;
fr.contentWindow.location.href=vo;
}
function tobasket()
{
var a="/corefx/start/main?scope=basket";
var ob=document.getElementById("myframe");
ob.contentWindow.location.href=a;
}
function tocart()
{
var cat=getParam("category");
var sco=getParam("mscope");
var select=getParam("selected");
var nsr="/corefx/start/main?scope="+sco+"&selected="+cat+"&good="+select;
var vas=nsr+"&cart=true";
document.location.href=vas;
}
function escape(par,sel)
{
if(par)
{
var sle=par.getElementById("myframe");
if(sle)
{
sle.src="/corefx/start/main?scope=magazin?selected="+sel;
}
else
{
var pr=window.parent.document;
escape(pr,sel);
}
}
}
function resize(obj) 
{
var con = obj.contentWindow.document.getElementsByTagName("div");
obj.style.height = (con.length/2)*32+"px";
}
function hotselect(a)
{
var b="vin"+a;
var man=document.getElementById(b);
var v=window.top;
v.document.getElementById("myframe").src="/corefx/start/main?scope=magazin&selected="+a;
if(!contains(sle,a)){var dav="d_"+a;
{}man.innerHTML=man.innerHTML+"<iframe id='selframe"+a+"' onload='resize(this)' frameBorder='0' class='men' src='/corefx/start/main?scope=core&area=main&selected="+a+"' scrolling='no'>text</iframe>";
}else{cleanSle(a);
}sleepFor(400);
if(document.getElementById("selframe"+a)){document.getElementById("selframe"+a).value="text";
{}}tidyUp(a);
sle.push(a);
setTimeout(function(){getres();},500);
}
function tidyUp(a)
{
for(var i=0;i<sle.length;i++)
{
var a=sle[i];
var b="vin"+a;
var man=document.getElementById(b);
if(man)
{
var cont=man.innerHTML;
man.innerHTML=cont.substring(0,cont.indexOf("<iframe"));
cleanSle(a);
}
}
}
function cleanSle(a)
{
var sele=sle;
sle=[];
for(var i=0;i<sele.length;i++)
{
if(sele[i]!==a)
{
sle.push(sele[i]);
}
}
}
function parselect(a)
{
var fr=document.getElementById("myframe");
if(fr)
{
var sor=fr.src;
var seq=sor.split("&");
var first=seq[0];
var second=seq[1];
var frs=first.split("?");
var one=frs[1];
var value1=one.split("=");
var value2=second.split("=");
var va=sor.replace("selected="+value2[1],"selected="+a.substring(3));
var vo=va.replace("scope="+value1[1],"scope=category");
fr.src=vo;
fr.contentWindow.location.href=vo;
}
}
function toreg()
{
document.getElementById("myframe").src=path+"main?scope=demo&flow=reg";
}
function autores(a)
{
var newheight;
var newwidth;
a.height= (newheight) + "px";
var b = getParentElement("maintab");
b.height=(newheight+100)+"px";
if(a)
{
newheight=a.contentWindow.document.body.scrollHeight;
}
}
function autoResize(id)
{
var newheight;
var newwidth;
document.getElementById(id).height= (newheight) + "px";
document.getElementById("maintab").height=(newheight+100)+"px";
if(document.getElementById(id))
{
newheight=document.getElementById(id).contentWindow.document.body.scrollHeight;
}
}
function unshade(a)
{
document.getElementById(a).style.background="white";
}
function unshadeid(a)
{
document.getElementById(a).style.background="blue";
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
function getParByClass(bod,ar)
{
var cl = bod.getAttribute("class");
if(cl === ar)
{
return bod;
}
else
{
var par = bod.parentNode;
return getParByClass(par,ar);
}
}
function addCell(a)
{
var cn = document.getElementById("hidtab");
}
function kickAfter()
{
sleepFor(5000);
if(document.readyState === 'loading')
{
kickAfter();
}
}
function flowin(a)
{
window.top.lfp = null;
var sub = a.substring(3);
var lf = getParentElement("lafra");
var msc = getParam("mscope");
var sele = "";
var slt = getParam("selected");
var lt = document.getElementById("lantag").innerHTML.replace(/s/g, '');
window.top.lan = lt;
var cat ="cat";
var bf="";
var nw="";
var category="";
var notlast = true;
var sl = getParentElement("lnlab@main_r1c0_r0c0_r0c0");
sl.innerHTML = "";
window.top.lfp = "/corefx/start/main?scope=status&selected="+window.top.ID+"&mscope="+window.top.lang+category;
if(!window.top.lang)
{
window.top.lang = msc;
}
if(!slt)
{
slt="";
}
switch(slt)
{
case "":
{
bf="pone";
nw ="toptwo";
window.top.grid.push(a.substring(3)+"=step1");
window.top.ID = a.substring(3);
break;
}
case "male":
{
bf="pone";
nw ="toptwo";
window.top.grid.push(a.substring(3)+"=step1");
window.top.ID = a.substring(3);
break;
}
case "female":
{
window.top.grid.push(a.substring(3)+"=step1");
bf="pone";
nw ="toptwo";
window.top.ID = a.substring(3);
break;
}
case "cat":
{
bf="toptwo";
nw ="partthree";
window.top.cat = a.substring(3);
msc=lt;
window.top.grid.push(a.substring(3)+"=cat");
cat = "volume";
category = "&area="+window.top.cat+"&flow="+lt;
break;
}
case "volume":
{
bf="partthree";
nw ="partfour";
cat = "extra";
 window.top.vol = a.substring(3);
category = "&area="+window.top.cat+"&flow="+lt+"&seed="+window.top.vol;
window.top.grid.push(a.substring(3)+"=volume");
var dub = "rin"+sub;
window.top.volume = document.getElementById(dub).innerHTML;
break;
}
case "extra":
{
window.top.extra = a.substring(3);
window.top.ex = false;
var els = document.getElementsByName(sub);
lf.src = "/corefx/start/main?scope=status&selected="+window.top.ID+"&mscope="+window.top.lang+category;
break;
if(!contains(ext,sub))
{
notlast = false;
window.top.grid.push(a.substring(3)+"="+xx[count]);
window.top.ext.push(sub);
count = +count +1;
if(count === 0)
{
category = "&area="+window.top.cat+"&flow="+lt+"&seed="+window.top.vol+"&project="+window.top.extra;
   window.top.ctgr = category;
}
else
{
category = window.top.ctgr + "&"+xx[count]+"="+sub;
window.top.ctgr = category;
}
if(count === xx.length - 1)
{
window.top.ex = true;
}
}
for(var y = 0; y<els.length; y++)
{
els[y].style.visibility = "hidden";
els[y].style.height = "0px";
}
}
}
if(window.top.ex)
{
document.location.href = "/corefx/start/main?scope=actor&mscope="+lt+"&selected="+cat;
if(notlast)
{
var pon = getParentElement(bf);
pon.style.color = "black";
pon.style.textDecoration = "";
var pt = getParentElement(nw);
pt.style.textDecoration = "underline";
pt.style.color = "red";
}
else
{
document.location.href = "/corefx/start/main?scope=check&volume="+window.top.volume;
}
}
}
function flowit(a)
{
var fr;
var pat = "/corefx/start/";
fr.src = pat;
switch(a)
{
case "rates":
{
fr = document.getElementById("bod");
pat = pat+"main?scope=rates";
            break;
}
case "voices":
{
fr = document.getElementById("bod");
pat = pat+"main?scope=search";
break;
}
case "search":
{
fr = getParentElement("bod");
pat = pat+"main?scope="+a;
break;
}
case "login":
{
var cr = document.getElementById("card").innerHTML;
fr = document.getElementById("bod");
break;
if(isThing(cr))
{
pat = pat+"main?scope=present&signout=true";
}
else
{
pat = pat + "main?scope=login";
}
}
case "about":
{
fr = window.top.document.getElementById("bod");
pat = pat+"main?scope=info";
break;
}
}
}
function addParam(key,val)
{
var temp=window.location.href;
var res=temp+"&"+key+"="+val;
window.location.href=res;
}
function change(a)
{
var b="";
           var ele=document.getElementsByTagName("input");
insertParam("mscope",b);
for(i;i<ele.length;i++)
{
if(ele[i])
{
if(ele[i].type)
{
if(ele[i].type==="radio")
{
var tem=ele[i].getAttribute("id");
  if(tem)
{
if(tem==="newmenu")
{}}
else
{}                  if(ele[i].id!==a)
{
document.getElementById(ele[i].id).checked=false;
}
else
{
document.getElementById(a).checked=true;
b=a;
}
}
}
}
}
}
function unblock()
{
if(document.getElementById("att").checked)
{
setParam("block","n");
isBlock=true;
}
else
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
var tem=v1.replace("Admin","main")+"?scope="+sco+"&area=main"+"&selected="+sel;
if(tem.indexOf("translate")<0)
{
window.open(tem,"preview");
}
else
{
window.open("/corefx/start/main?scope=translate&ln=ru");
}
}
function person()
{
var lino=document.getElementById("meatframe");
lino.src="/corefx/start/main?scope=profile";
frames('meatframe').document.location.href='/corefx/start/main?scope=profile';
}
function submitEc()
{
var first = document.getElementById("first").value;
var last = document.getElementById("last").value;
var company = document.getElementById("company").value;
var email = document.getElementById("email").value;
var phone = document.getElementById("phone").value;
var comment = document.getElementById("comment").value;
var pa = path +"main?scope=confex&first="+first+"&last="+last+"&company="+company+"&email="+email+"&phone="+phone+"&comment="+comment;
document.location.href = pa;
}
function showno()
{
var obm=document.getElementById("2mat");
var m2=document.getElementById("2mat").firstChild.data;
if(m2.length<1)
{
document.getElementById("2mav").style.visibility="hidden";
document.getElementById("2mat").style.visibility="hidden";
document.getElementById("2hiv").style.visibility="visible";
}
}
window.showme=function(a)
{
var ar=a.substring(0,a.length-2);
document.getElementById(ar).style.visibility="visible";
ison=true;
};
window.raise=function(a)
{
var cl=a.substring(0,9);
var b=a.substring(9,a.length-3);
window.open("/corefx/start/main?selected="+b+"&scope=build&cell="+cl, "create", "'left=100,top=100,width=700,height=500,toolbar=1,resizable=1'");
};
function tospin(a,b)
{
document.getElementById(a).style.visibility="hidden";
document.getElementById(b).style.visibility="visible";
bshow=b;
}
function spin()
{
var dv=["fdiv","rdiv","ldiv","badiv"];
var mid=["fidiv","ridiv","lidiv","baidiv"];
for(var i=0;i<dv.length;i++)
{
var nm=dv[i];
if(nm===bshow)
{
if(i<dv.length-1)
{
var element=document.getElementById(nm);
element.style.visibility="hidden";
var el=document.getElementById(mid[i]);
if(el)
{
document.getElementById(mid[i]).style.visibility="visible";
var m=mid[i];
var n=dv[i+1];
setTimeout(function(){tospin(m,n);},150);
}
}
else
{
var ele=document.getElementById(nm);
ele.style.visibility="hidden";
document.getElementById(mid[i]).style.visibility="visible";
var mo=mid[i];
var no=dv[0];
bshow=dv[0];
setTimeout(function(){tospin(mo,no);},200);
}
}
}
}
window.move=function(a)
{
var rw=["c1div","c2div","c3div","c4div","topdiv","rightdiv","leftdiv","bottomdiv"];
for(var i=0;i<rw.length;i++)
{
var ro=a+rw[i];
var res=ro.substring(3);
var v=document.getElementById(res).top;
if(!ison)
{
document.getElementById(res).style.visibility="hidden";
}
}
};
window.hideme=function(a)
{
document.getElementById(a).style.visibility="hidden";
    document.getElementById(a).style.border="1px dashed greenyellow";
  ison=false;
};
function editorder()
{
var order=getParam("selected");
var path="/corefx/start/Reg?flow=cancel&ord="+order;
document.location.href=path;
}
function getres()
{
window.top.document.getElementById("myframe").style.height=window.top.document.getElementById("myframe").contentWindow.document.body.scrollHeight+"px";
window.top.document.getElementById("hotpage@main_r2c0").style.height = window.top.document.getElementById("myframe").style.height;
}
function getorder(a)
{
var b=a.substring(3);
document.location.href="/corefx/start/main?scope=confirm&flow=view&selected="+b;
}
function buy()
{
document.location.href="/corefx/start/main?scope=demo&flow=order";
}
function isValidEmail(email) 
{
var re = /^([w-]+(?:.[w-]+)*)@((?:[w-]+.)*w[w-]{0,66}).([a-z]{2,6}(?:.[a-z]{2})?)$/i;
return re.test(email);
}
function hogproceed()
{
var fin = document.getElementById("fin").value;
var lin = document.getElementById("lin").value;
var emin = document.getElementById("emin").value;
var phonin = document.getElementById("phonin").value;
var comin = document.getElementById("comin").value;
var OK = true;
var st = [fin,lin,emin,phonin,comin];
var str = ["first name","last name","email","phone number","company"];
for(var i=0; i<st.length; i++)
{
if(!isThing(st[i]))
{
OK = false;
alert("Please enter "+str[i]);
}
}
if(OK)
{
if(!isValidEmail(emin))
{
OK = false;
alert("Please enter valid email");
}
}
if(OK)
{
document.location.href = path+"main?scope=hogplan&hogregister=true&finame="+fin+"&lastname="+lin+"&email="+emin+"&phone="+phonin+"&company="+comin;
}
}
function proceed()
{
var flow=getParam("flow");
var finame=document.getElementById("firstname").value;
var laname=document.getElementById("lastname").value;
var phone=document.getElementById("phone").value;
var mail=document.getElementById("mail").value;
var city=document.getElementById("town").value;
var region=document.getElementById("region").value;
var street=document.getElementById("lane").value;
var dom=document.getElementById("dom").value;
var app=document.getElementById("appartment").value;
var ord="/corefx/start/Reg?first="+finame+"&last="+laname+"&phone="+phone+"&email="+mail+"&town="+city+"&region="+region+"&street="+street+"&dom="+dom+"&appartment="+app+"&flow="+flow;
var valid=isValidEmail(mail);
if(finame&&phone)
{
if(valid)
{
document.location.href=ord;
}
else
{
alert("address may be wrong");
}
}
else
{
alert("first and last name must be filled");
}
}
function golog()
{
var l=document.getElementById("loin").value;
var p=document.getElementById("pasin").value;
window.top.document.location.href = path+"main?scope=hotpage&lin="+l+"&pin="+p;
}
function toOrders()
{
document.getElementById("myframe").src="/corefx/start/main?scope=order";
}
function getout()
{
var pat="/corefx/start/main?scope=par&exit=true&selected=main";
 window.top.document.location.href=pat;
}
function login()
{
document.getElementById("myframe").contentWindow.location.href="/corefx/start/main?scope=sign";
}
function confirm()
{
var sel=getParam("selected");
var ca=document.getElementById("conarea").value;
window.document.location.href="/corefx/start/Reg?flow=confirmed&ord="+sel+"&comment="+ca;
}
function docontinue()
{
var ad="";
window.top.document.getElementById("bod").src = "/corefx/start/main?scope=checkout&voiceid="+window.top.ID+"&volume="+window.top.vol+"&category="+window.top.cat+"&extra="+ad+"&tongue="+window.top.lang;
for(var i=0; i<window.top.ext.length; i++)
{
if(i<window.top.ext.length-1)
{
ad=ad+window.top.ext[i]+",";
}
else
{
ad=ad+window.top.ext[i];
}
}
}
function yes(a)
{
window.document.location.href="/corefx/start/Reg?flow=cancel&conf=true&ord="+a;
}
function nono()
{
document.location.href="/corefx/start/main?scope=magazin&selected=paravoz";
}
function cancel()
{
var flow=getParam("flow");
if(flow!==null)
{
if(flow==="order")
{
document.location.href="/corefx/start/main?scope=basket";
}
else
{
document.location.href="/corefx/start/main?scope=magazin&selected=paravoz";
}
}
else
{
document.location.href="/corefx/start/main?scope=magazin&selected=paravoz";
}
}
function signoff()
{
document.location.href=path+"main?scope=hotpage&exit=true";
document.location.href=path+"main?scope=hotpage&exit=true";
}
function calcul(a)
{
b=a.substring(3);
var qq="/corefx/start/main?scope=basket&prodid="+b+"&amount="+document.getElementById(a).value;
document.location.href=qq;
}
function getfocus(a)
{
var ob = document.getElementById(a);
if(ob)
{
ob.focus();
}
}
function doref()
{
var tem=window.location.href;
window.location.href=tem+"&refresh=y";
}
function goaccount()
{
var crd = document.getElementById("account");
var v = crd.innerHTML;
if(exp)
{
crd.innerHTML=mytext;
mytext = "";
exp = false;
}
else
{
mytext=crd.innerHTML;
crd.innerHTML = v+' '+"<div id='prfl' class='acmen' onclick='doflow(id)'>account</div>"+' '+"<div id='signout' class='acmen' onclick='signoff()'>log out</div>";
    exp = true;
}
}
function getExtraPrice(a)
{
var result = 0;
return result;
switch(a)
{
case "pay":
{
result = 150;
break;
}
case "integrate":
{
result = 100;
break;
}
case "integration":
{
result = 100;
break;
}
case "booking":
{
result = 70;
break;
}
case "cont":
{
result = 100;
break;
}
case "rate":
{
result = 50;
break;
}
case "forum":
{
result = 80;
break;
}
case "review":
{
result = 50;
break;
}
case "hr":
{
result = 70;
break;
}
case "ecom":
{
result = 250;
break;
}
case "corporate":
{
result = 200;
break;
}
case "personal":
{
result = 100;
break;
}
case "other":
{
result = 100;
break;
}
case "admin":
{
result = 50;
break;
}
case "client":
{
result = 50;
break;
}
}
}
function getExtra(a)
{
var result = "";
return result;
switch(a)
{
case "pay":
{
result = "accept payments";
break;
}
case "integrate":
{
result = "integration with external systems";
break;
}
case "integration":
{
result = "integration with external systems";
break;
}
case "booking":
{
result = "booking wizard";
break;
}
case "cont":
{
result = "content management system";
break;
}
case "rate":
{
result = "allow to rate your products";
break;
}
case "forum":
{
result = "add community forum";
break;
}
case "review":
{
result = "customer reviews";
break;
}
case "hr":
{
result = "HR tools";
break;
}
case "client":
{
result = "client base management tools";
break;
}
case "admin":
{
result = "admin screen";
break;
}
case "catalog":
{
result = "any tree catalog";
break;
}
case "redextra":
{
result = "e-commerce application";
break;
}
case "redcorp":
{
result = "corporate web-site";
break;
}
case "redpers":
{
result = "personal web-site";
break;
}
case "redother":
{
result = "custom made web application";
break;
}
}
}
function savevoice()
{
var voiceid=document.getElementById("username").value;
var fields = ["first","last","phone","gender","postcode","address","city","dob","experience","second","brands","term","countsel","lansel","timesel"];
var fld = [];
var sum = document.getElementById("atext").value;
var pat = "/corefx/start/main?scope=loading&summ="+sum+"&voiceid="+voiceid;
document.location.href = pat.replace("countsel","country").replace("lansel","language").replace("timesel","time").replace("%20"," ");
for(var i = 0; i<fields.length; i++)
{
var value = document.getElementById(fields[i]).value;
pat = pat+"&"+fields[i]+"="+value+"&soco=voice";
}
}
function on_load()
{
       var lload = window.top.document.getElementById("trans");
var scope=getParam("scope");
var sc=getParam("mscope");
var sel=getParam("selected");
var par=getParam("parent");
var bil=getParam("block");
var lu=getParam("lin");
var are=getParam("area");
var created=getParam("created");
var fromsel=getParam("fromsel");
var real=getParam("real");
var ob=document.getElementById("usep");
var cart=getParam("cart");
var dir=getParam("dir");
if(lload)
{
lload.style.visibility = "hidden";
}
if(real)
{
var obcom=document.getElementById("comm");
if(obcom)
{}}
if(created)
{
handleCreated(created);
}
if(dir)
{
if(dir==="reg")
{
window.top.document.getElementById("rama").src="/corefx/start/main?scope=user";
}
if(dir === "1"||dir === "3")
{
window.top.document.location.href = "/corefx/start/main?scope=hotpage";
}
}
if(cart)
{
if(cart==="true")
{
window.top.document.location.href="/corefx/start/main?scope=hotpage&selected=main&recalc=true";
}
}
if(scope)
{
var scp = getParam("area");
var el = getParam("selected");
var j = 0;
if(scope === "setemail")
{
var datatab1 = getParam("datatab1");
var datatab2 = getParam("datatab2");
          document.getElementById("password").value = getParam("password");
document.getElementById("label").value = getParam("emailid");
document.getElementById("lan").value = getParam("lan");
if(datatab1 === "true")
{
document.getElementById("datatab1").checked = true;
}
if(datatab2 === "true")
{
document.getElementById("datatab2").checked = true;
}
}
if(scope === "event")
{
document.getElementById("event").value = getParam("type");
popevent();
var inv = document.getElementById("pinNo Item In View");
addDash("parsel");
if(inv)
{
inv.style.visibility = "hidden";
}
}
if(scope === "terminate")
{
var ar = getParam("area");
if(ar)
{
if(ar === "top")
{
window.top.close();
}
else
{
window.close();
}
}
else
{
window.close();
}
}
if(scope === "newboard")
{
var emp = document.getElementsByClassName("smallblackwide");
var bl = false;
for(var i = 0; i<emp.length; i++)
{
if(emp[i].innerHTML === "No Item In View")
{
emp[i].innerHTML = "";
bl = true;
}
}
if(bl)
{
var rad = document.getElementsByTagName("input");
for(var i = 0; i<rad.length; i++)
{
if(rad[i].getAttribute("type") === "radio")
{
rad[i].disabled = true;
}
}
}
}
if(scope === "redreg")
{
comment = getParam("comment");
var suff = "";
document.getElementById("stuff").innerHTML = getExtra(getParam("prod")) + " with extras: " + getParam("list").substring(0,getParam("list").length-1) + suff;
if(isThing(comment))
{
suff = ". The following comment was provided: "+comment;
}
}
if(scope === "redquote")
{
mprice = 0;
var extras = document.getElementById("listing");
var lst = extras.innerHTML.split(",");
var list = "";
var ar = getParam("area");
mprice = getExtraPrice(ar);
listString = list;
prod = ar;
extras.innerHTML = list.substring(0,list.length - 1);
document.getElementById("price").innerHTML = mprice + "USD";
if(isThing(getParam("comment")))
{
comment = getParam("comment");
}
for(var i = 0; i<lst.length; i++)
{
var xt = getExtra(lst[i]);
mprice = + mprice + + getExtraPrice(lst[i]);
if(i<lst.length-1)
{
list = list + xt + ",";
}
else
{
list = list + xt;
}
}
}
if(scope === "stage")
{
var ob = document.getElementById("jinNo Item In View");
if(ob)
{
ob.style.visibility = "hidden";
}
}
if(scope === "logman")
{
var er = document.getElementById("error");
var err = getParam("message");
if(isThing(err))
{
er.innerHTML = "неправильный имейл или пароль.";
}
}
if(scope === "genug")
{
window.close();
}
if(scope === "preview")
{
var par = document.getElementById("req").value;
document.getElementById("prefra").src = "/corefx/start/Preview?scope=preview&area="+scp+"&element="+el+par;
if(par)
{
if(par.indexOf("&")!==0)
{
par = "&"+par;
}
}
}
if(scope === "attnew")
{
if(isThing(getParam("close")))
{
window.close();
}
}
if(scope === "stage")
{
var area = getParam("area");
var parlink = document.getElementById("parlink").innerHTML;
document.getElementById("efra").src = "/corefx/start/table?edit="+getParam("selected")+"&area="+area+"&parent="+parlink+"&real=true";
}
if(scope === "board")
{
if(getParam("mscope") ==="null")
{
document.getElementById("board").checked=true;
}
}
if(scope === "FAQ")
{
var bd = window.top.document.getElementById("bod");
bd.style.height = "500px";
}
if(scope === "info")
{
var bd = window.top.document.getElementById("bod");
bd.style.height = "1350px";
bd.scrolling = "yes";
}
if(scope === "contact")
{
var casel = document.getElementById("cat");
var ca = getParam("selected");
var bd = window.top.document.getElementById("bod");
bd.style.height = "500px";
switch(ca)
{
case "howreg":
{
casel.value="job";
break;
}
case "find":
{
casel.value="voice";
break;
}
case "hore":
{
casel.value="studio";
break;
}
case "general":
{
casel.value="general";
break;
}
}
}
if(scope === "present")
{
var sgn = getParam("signout");
if(isThing(sgn))
{
window.top.document.location.href = path+"main?scope=ecrivus";
}
}
if(scope === "loading")
{
var soco = getParam("soco");
if(isThing(soco))
{
if(soco === "rates")
{
var cat = getParam("cat");
document.location.href = path+"main?scope=rates&cat="+cat;
}
if(soco === "voice")
{
replaceParam("scope","voice");
}
if(soco === "red")
{
document.getElementById("loading@main_r0c0").style.top = "70px";
 listString = getParam("list");
comment = getParam("comment");
prod = getParam("area");
var name = getParam("name");
var email = getParam("email");
pa = path+"main?scope=redme&name="+name+"&email="+email+"&comment="+comment+"&area="+prod+"&list="+listString+"&redreg=true";
document.location.href = pa;
}
}
else
{
document.location.href = path+"main?scope=voice";
}
}
if(scope === "Upload")
{
if(isThing(getParam("actor")))
{
var b = document.getElementById("hidus").innerHTML;
var ttl = document.getElementById("imlink");
ttl.value = b;
ttl.disabled = true;
ttl.style.visibility = "hidden";
document.getElementById("telab").style.visibility="hidden";
}
if(isThing(getParam("mscope")))
{
document.getElementById("imlink").value = getParam("mscope");
}
}
if(scope === "control")
{
var a = document.getElementById("zinNo Item In View");
if(a)
{
a.style.visibility = "hidden";
}
}
if(scope === "media")
{
var au = document.getElementsByTagName("audio");
for(var g = 0; g<au.length; g++)
{
var elm = au[g];
var elid = elm.getAttribute("id");
if(elid.indexOf("No Item")>-1)
{
var parel = elm.parentNode;
parel.style.visibility = "hidden";
}
}
}
if(scope === "voice")
{
window.top.document.getElementById("bod").style.height = "1500px";
window.top.document.getElementById("maintab").style.height = "1500px";
      var cntr = document.getElementById("vincountry").innerHTML.replace("%20"," ");
var lngv = document.getElementById("vinlanguage").innerHTML.replace("%20"," ");
var time = document.getElementById("vintime").innerHTML.replace("%20"," ");
var cosl = document.getElementById("countsel");
var lans = document.getElementById("lansel");
var tims = document.getElementById("timesel");
cosl.value = cntr;
lans.value = lngv;
tims.value = time;
}
if(scope === "status")
{
var lafr = getParentElement("lafra");
var pr = getParamFromString(lafr.src,"scope");
var nm = document.getElementById("status@status@statdiv@main_r1c0").innerHTML;
var okna = document.getElementsByClassName("acdiv");
var vd = window.screen.availHeight;
window.top.document.getElementById("bod").clientHeight = +vd+200+"px";
window.top.document.getElementById("maintab").clientWidth = +vd+200+"px";
if(nm!== undefined)
{
window.top.namo = nm;
}
for(var v = 0; v<okna.length; v++)
{
var vav = okna[v];
var im = vav.getElementsByTagName("img");
var ima = im[0];
var sr = ima.getAttribute("src");
if(!sr)vav.style.visibility = "hidden";
{}}
}
if(scope === "actor")
{
var elem = document.getElementsByName("No Item In View");
var frap = window.frameElement;
var fid = frap.getAttribute("id");
var lan = getParam("mscope");
var gen = getParam("selected");
var laf = getParentElement("lafra");
var vr = laf.contentWindow.document.getElementById("mainmainrow0col0").innerHTML;
for( var j = 0; j<elem.length; j++)
{
elem[j].style.visibility = "hidden";
}
if(!isThing(lan))
{
document.getElementById("work").style.visibility = "hidden";
}
if(gen)
{
if(gen!=='male'&gen!=='female')
{
document.getElementById("girl").style.visibility = "hidden";
document.getElementById("boy").style.visibility = "hidden";
var wrp = document.getElementsByClassName("playwrap");
for(var z = 0; z<wrp.length; z++)
{
var pw = wrp[z];
pw.style.visibility = "hidden";
}
if(gen === "extra")
{
var trp = document.getElementById("hidtab");
trp.style.visibility = "visible";
}
}
}
else
{}if(window.top.lfp)
{
laf.src = window.top.lfp;
}
if(!vr.contains("You selected"))
{
var sr = laf.src;
laf.src = sr;
}
}
if(scope === "checkout")
{
var wicl = document.getElementsByClassName("wide");
var total = 0;
document.getElementById("totalvalue").innerHTML = total+" "+"&euro";
var vid = document.getElementById("rilab").clientHeight;
document.getElementById("ladiv").style.height = +vid -15 +"px";
for(var i = 0; i < wicl.length; i++)
{
var wdi = wicl[i].getAttribute("id");
if(wdi === "checkout@checkout@right@main_r0c1")
{
total = +total + +wicl[i].innerHTML;
}
}
}
if(scope === "check")
{
document.getElementById("voice").innerHTML = window.top.namo;
document.getElementById("language").innerHTML = window.top.lang;
document.getElementById("product").innerHTML = window.top.cat;
document.getElementById("volume").innerHTML = window.top.volume;
document.getElementById("summa").innerHTML = calculate(window.top.ID,window.top.cat,window.top.vol,window.top.extra);
var vob = document.getElementById("total");
var vobleft = vob.style.left;
var vobwidth = vob.clientWidth;
var con = document.getElementById("continue");
var conleft = +vobleft + + vobwidth - +con.clientWidth - 200+"px";
con.style.left = conleft;
var vd = getParentElement("lefra").contentWindow.availHeight;
window.top.document.getElementById("bod").clientHeight = +vd+200+"px";
window.top.document.getElementById("maintab").clientWidth = +vd+200+"px";
for(var g = 0; g<window.top.xx.length; g++)
{
if(g<window.top.ext.length)
{
var run = "pin"+g;
document.getElementById(run).innerHTML = window.top.ext[g];
}
  else
{
var vin = "vin"+g;
document.getElementById(vin).style.visibility = "hidden";
}
}
}
if(scope === "rates")
{
var jt = document.getElementById("maintab").clientHeight;
getParentElement("bod").style.height = jt+"px";
getParentElement("maintab").style.height = 200+ +jt +"px";
}
if(scope === "search")
{
var wind = window.innerWidth;
var cd = document.getElementById("condiv");
cd.style.left = +wind * 0.1 +"px";
document.getElementById("mainsetab@main_r1c0row0col0").style.width = "130px";
var el = getParentElement("bod");
getParentElement("bod").style.height = "1000px";
getParentElement("maintab").style.height = "1000px";
document.getElementById("lafra").style.height = "900px";
document.getElementById("sefra").style.height = "900px";
if(isThing(getParam("lani")))
{
var lani = getParam("lani");
var vala = document.getElementById("sefra").src;
vala = cleanParam(vala,["mscope"]);
document.getElementById("sefra").src = vala+"&mscope="+lani;
}
}
if(scope === "ecrivus")
{
document.getElementById("face").style.position="relative";
document.getElementById("face").style.margin="10px";
var wi=window.document.getElementById("maintab").clientWidth;
var tp = document.getElementById("toptop");
var clw = tp.clientWidth;
var ft = document.getElementById("footer").clientHeight;
tp.style.left = wi-1070+"px";
var ih = window.innerHeight;
var ec = tp.clientHeight;
var bd = document.getElementById("bod");
bd.style.height = +ih - +ec +"px";
var lg = document.getElementById("login");
var cr = document.getElementById("card").innerHTML;
var dc = document.getElementById("header@main_r0c0").clientHeight;
window.document.getElementById("maintab").clientHeight = +ih - +ec + +ft + +dc+"px";
if(isThing(cr))
{
lg.innerHTML = "LOGOUT";
}
}
if(scope === "type")
{
var p = window.parent;
var par = p.parent;
par.document.getElementById("typ").style.background = "red";
}
if(scope === "quick")
{
var tp = getParam("tp");
var cl = getParam("cl");
var cn = getParam("cn");
var id = getParam("id");
var onc = getParam("onc");
var sr = getParam("sr");
var hr = getParam("hr");
var isl = getParam("isl");
var car = [tp,cl,cn,id,onc,sr,hr,isl];
var cr = ["tp","cl","cn","id","onc","sr","hr","isl"];
var cra = ["type","class","content","id","onclick","src","href","query"];
document.getElementById("0").value = "row";
document.getElementById("1").value = "col";
var name = getParam("selected");
var rocol = getRocol(name);
var rw = getRo(rocol);
var col = getCo(rocol);
document.getElementById("vin0").value = rw;
document.getElementById("vin1").value = col;
for(var i = 0; i < cr.length; i++)
{
var key = "vin"+cr[i];
var val = cr[i];
document.getElementById(key).value = cra[i];
if(car[i] !== "undefined"&car[i]!== "null")
{
document.getElementById(val).value = car[i];
}
else
{
document.getElementById(val).value = "";
}
}
}
if(scope === "wizard")
{
if(window.top.elementname === undefined)
{
dis("ID");
dis("content");
dis("CLASS");
dis("click");
dis("HREF");
dis("SRC");
dis("isel");
dis("typ");
dis("custom");
}
}
if(scope === "class")
{
var ele = document.getElementsByTagName("div");
for(var i = 0; i<ele.length; i++)
{
var el = ele[i];
      el.style.position = "relative";
el.style.left = "0px";
el.style.width ="140px";
el.style.height = "20px";
el.style.margin = "0px";
el.style.top = "0px";
el.style.top = "0px";
el.style.visibility = "visible";
el.style.cursor="pointer";
if(i<10)
{}}
}
if(scope === "constructor")
{
var v = document.getElementById("conframe@main_r1c0");
if(v)
{
v.src = "/corefx/start/main?scope=dummy";
}
}
if(scope === "custom")
{
var fram = document.getElementById("lefram");
var ar = getParam("area");
var sl = getParam("selected");
{
if(sl!=="class"&sl !== "onclick"&sl!=="type")
{
document.getElementById("custom@main_r3c0").style.visibility = "hidden";
}
 else
{
switch(sl)
{
case "class":
{
var ms = path+"main?scope=class&selected=class&mscope="+window.top.type;
fram.src = ms;
break;
}
case "type":
{
fram.src = path+"main?scope=type";
break;
}
}
}
}
}
if(scope === "addnew"|scope === "class")
{
setTimeout(function(){fade();},2000);
}
if(scope==="element"||scope==="tag")
{
onelement();
}
if(scope === "core")
{
var non = document.getElementById("No Item In View");
var v = document.getElementsByTagName("div");
var cot = v.length;
count=(cot/2)*35;
var soel = getParam("selected");
var prt = parent.document.getElementById("selframe"+soel);
parent.document.getElementById("selframe"+soel).style.height = count+"px";
if(non)
{
var nob = document.getElementById("vinNo Item In View");
if(nob)
{
nob.style.visibility = "hidden";
}
}
if(prt)
{}}
if(scope === "prod")
{
		var pr = document.getElementById("prodesc");
		if(pr)		
{
			pr.style.lineHeight = "3";
}
}
}
else
{}if(scope === "person")
{
var fled = ["phone","email"];
for(var i=0; i<fled.length;i++)
{
var ob = document.getElementById(fled[i]);
ob.disabled = true;
ob.style.background = "pink";
}
}
if(scope === "confirm")
{
if(isThing(getParam("flow")))
{
if(getParam("flow") === "view")
{
document.getElementById("confibut").disabled = true;
}
}
}
if(scope==="hotpage")
{
var wi=window.screen.availWidth;
var clw = document.getElementById("maintab").clientWidth-359;
var card = document.getElementById("account").innerHTML;
if(card){if(card.length>0){var crd = document.getElementById("account");
{}crd.style.visibility = "visible";
crd.style.top="10px";
crd.style.left = document.getElementById("maintab").clientWidth-140+"px";
var wd = crd.offsetWidth;
crd.style.backgroundSize = wd+30+"px 40px";
}}document.getElementById("mainhotpage@main_r2c0row0col0").width="240px";
var middl=wi-320;
document.getElementById("mainhotpage@main_r2c0row0col1").width=middl+"px";
var bas=document.getElementById("basket");
var ava=wi-445;
var wid=(clw/6)-10;
var names=["products","about","orders","sign-in","sign-up","cart"];
document.getElementById("mainhotheadrow0col0").width="353px";
if(bas){var coun=bas.innerHTML;
{}if(coun!=="0"){bas.style.visibility="visible";
{}}bas.style.left=wid*0.6+"px";
}for(i=0;
i<names.length;
i++){var name=names[i];
document.getElementById(name).style.width=wid;
var j = i+1;
var td = "mainhotheadrow0col"+j;
document.getElementById(td).width = wid;
}var catop = document.getElementById("cart").style.top;
var calef = document.getElementById("cart").style.left;
var ft = document.getElementById("fodiv");
if(ft){   ft.style.width = wi;
{}}if(scope === "demo"){var fname = document.getElementById("firstname");
if(fname){fname.focus();
{}}}if(scope==="att"){var atob=document.getElementById("atfram");
if(atob){atob.src="/corefx/start/main?scope=upload&selected=main&mscope=main&block=y&v="+sel;
{}}}setTimeout(function(){getres();},300);
}
if(scope==="pot")
{
var openid=getParam("openid.identity");
var colone=document.getElementById("mainpobodytabrow0col0");
var coltri=document.getElementById("mainpobodytabrow0col2");
if(openid)
{
document.getElementById("posteam").style.visibility="hidden";
document.getElementById("poavdiv").style.visibility="visible";
}
if(colone)
{
colone.width="20%";
}
if(coltri)
{
coltri.width="20%";
}
}
if(scope==="user")
{
var admin=document.getElementById("hid").value;
if(admin)
{
if(admin==="yes")
{
document.getElementById("adm").style.visibility="visible";
}
}
}
if(scope==="confirm")
{
window.top.document.getElementById("rama").src="/corefx/start/main?scope=user";
}
if(scope==="magazin")
{
var vop=getParam("logged");
if(vop)
{
if(vop==="true")
{
window.top.document.getElementById("rama").src=path+"main?scope=user";
}
}
}
if(scope==="myprod")
{
var adm = window.top.document.getElementById("hotpage@main_r4c0");
document.getElementById("proadmin").style.visibility = "visible";
document.getElementById("addi").style.visibility = "visible";
     if(adm)
{
if(adm.innerHTML!=="yes")
{
document.getElementById("proadmin").style.visibility = "hidden";
document.getElementById("addi").style.visibility = "hidden";
}
}
}
if(scope==="demo")
{
var demd=document.getElementById("zakaz");
var flow=getParam("flow");
if(flow!==null)
{
if(flow!=="order")
{
document.getElementById("zakaz").style.visibility="hidden";
}
}
else
{
document.getElementById("zakaz").style.visibility="hidden";
}
}
if(scope==="basket")
{
var ind=document.getElementById("index");
if(ind)
{
document.getElementById("stat").style.visibility="visible";
}
else
{
document.getElementById("mess").style.visibility="visible";
}
}
if(scope==="map")
{}if(scope==="query")
{
document.getElementById("qrtxt0").value=getParam("isel");
var schema="";
var table=document.getElementById("table").firstChild.data;
var column=document.getElementById("column").firstChild.data;
var fiels=document.getElementById("fields").firstChild.data;
var vals=document.getElementById("vals").firstChild.data;
var colnum=document.getElementById("colnum").firstChild.data;
var order=document.getElementById("order").firstChild.data;
var isel2="";
document.getElementById("qrtxt1").value=schema;
document.getElementById("qrtxt2").value=table;
document.getElementById("qrtxt3").value=column;
         document.getElementById("qrtxt4").value=fiels;
 document.getElementById("qrtxt5").value=vals;
  document.getElementById("qrtxt6").value=colnum;
document.getElementById("qrtxt7").value=order;
document.getElementById("qrtxt8").value=isel2;
if(document.getElementById("schema").firstChild!==null)
{
schema=document.getElementById("schema").firstChild.data;
}
if(document.getElementById("isel2").firstChild!==null)
{
isel2=document.getElementById("isel2").firstChild.data;
}
}
if(ob!==null)
{
var usl=document.getElementById("usep").firstChild.data;
if(usl.length>0)
{
document.getElementById("perlay").style.visibility="visible";
}
}
if(lu!==null)
{
if(lu.length>0)
{
var pin = getParam("pin");
var lin = getParam("lin");
var bod = document.location.href;
var bo1 = dodel(bod,"lin",lin);
var bo2 = dodel(bo1,"pin",pin);
document.location.href=bo2;
}
}
if(getParam("v")==="")
{
if(scope==='profile')
{}if(scope==='selector')
{
if(sel==='')
{
addParam("selected","main");
}
}
if(scope==='prod')
{
loadField('id','idtxt');
cleanDesc();
}
if(bil==="y")
{
if(document.getElementById("att"))
{
document.getElementById("att").checked=false;
}
}
else
{
if(document.getElementById("att"))
{
document.getElementById("att").checked=true;
}
}
if(scope==="edit")
{
if(sel.length<1)
{
document.getElementById("checkparent").value=par;
document.getElementById("checkscope").value=sc;
document.getElementById("checkblock").value=bil;
}
}
if(scope.length<1)
{
if(scope==='')
{
var flo=getParam("flow");
if(flo==='') 
{
var temp=window.location.href;
var temo=temp.replace("main","Admin");
var tem=temo;
d="?scope=admin&selected=main&mscope=main&block=y";
 window.location.replace(tem+d);
if(document.getElementById("main"))
{
document.getElementById("main").checked=true;
}
}
}
}
else
{
sc=getParam("mscope");
var bl=getParam("block");
if(sc)
{
if(getParam("scope")!=="par")
{
if(document.getElementById(sc))
{
document.getElementById(sc).checked=true;
}
}
}
if(par!=='')
{
document.getElementById("checkparent").value=par;
}
}
}
else
{
document.getElementById("imlink").value=getParam("v");
}
}
function about()
{
document.getElementById('myframe').contentWindow.location.href="/corefx/start/main?scope=about";
}
function deliver()
{
document.getElementById('myframe').contentWindow.location.href="/corefx/start/main?scope=delivery";
}
function goadmin()
{
var ad=window.top.document.getElementById('myframe');
ad.contentWindow.location.href="/corefx/start/main?scope=admin&selected=main&mscope=par&block=y";
}
function validate(a)
{
    var b=document.getElementById(a).value;
                   document.getElementById(a).style.color="green"; 
                   if(streight)
                       {
                   document.getElementById("abut").disabled=false;
                       }
    var ar=new Array("?","&","#","'",")","(","|","}","{","<",">","]","[",";",'"');
     
    for(i=0;i<ar.length;i++)
        {
         // 
            if(document.getElementById(a).value.indexOf(ar[i])>-1)
                {
                   document.getElementById(a).style.color="red"; 
                   document.getElementById("abut").disabled=true;
                   streight=false;
                   
                   break;
                }
        }
        
}
function calculate(name,prod,volume,extra)
{
var conc = name+prod+volume+extra;
var cc = +window.top.xx.length * 70;
var result = 350 +"&euro";
return result;
switch(conc)
{
case "Andreas 2corporateone1edit":
{
result = "350"+"&euro";
break;
}
case "Meriamcorporateone1edit":
{
result = "400"+"&euro";
break;
}
}
}
function popimg(a)
{
var r=document.getElementById("checkname").value;
var p=document.getElementById("checkparent").value;
if(r==='src')
{
if(a==='checkvalue')
{
document.getElementById(a).value="/corefx/start/img~id@"+p;
}
}
}
function board()
{
streight=true;
validate("textemail2");
validate("textcity");
validate("textfirst");
validate("textlast");
validate("textcountry");
validate("textphone");
}
function prodit()
{
replaceIt("email2");
replaceIt("city");
replaceIt("first");
replaceIt("last");
replaceIt("country");
replaceIt("phone");
document.getElementById("visimg").style.visibility="hidden";
document.getElementById("llay").style.height="200px";
document.getElementById("llay").style.top="0px";
document.getElementById("llay").style.visibility="visible";
document.getElementById("visimg").style.height="0px";
document.getElementById("lbat").style.height="80px";
document.getElementById("lbat").style.width="160px";
document.getElementById("lbat").style.visibility="visible";
document.getElementById("visimg").style.width="0px";
document.getElementById("pim").style.height="0px";
document.getElementById("pim").style.width="0px";
}
function hove()
{
document.getElementById("lbat").style.background="green";
document.getElementById("lbat").style.coursor="hand";
}
function unhove(a)
{
document.getElementById(a).style.background="lightcyan";
}
function bring()
{
document.getElementById("lalo").style.top="0px";
document.getElementById("lalo").style.left="0px";
document.getElementById("lalo").style.visibility="visible";
document.getElementById("lalo").style.opacity=1;
}
function replaceIt(a)
{
var txt="serv"+a;
var show="show"+a;
var inp="text"+a;
document.getElementById(txt).style.visibility="hidden";
document.getElementById(show).style.visibility="hidden";
document.getElementById(a).style.visibility="visible";
var va=document.getElementById(txt).firstChild.firstChild.data;
if(document.getElementById(show).firstChild!==null)
{
document.getElementById(inp).value=va+document.getElementById(show).firstChild.data;
}
else
{
document.getElementById(inp).value=va;
}
}
function goimg()
{
var v1=document.getElementById("idtxt").value;
proform.action="/corefx/start/main?scope=Upload&id="+v1;
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
var temp=window.location.href;
var sel="main";
var scp="main";
var par="root";
var ar=temp.split("?");
imgform.action="/corefx/start/main?scope=Admin&selected="+sel+"&mscope="+scp+"&block=y";
}
function toprod()
{
var s=document.getElementById("imlink").value;
imgform.action="/corefx/start/main?scope=prod&id="+s;
}
function topro()
{
imgform.action="/corefx/start/main?scope=prod&";
}
function topr1()
{
var v=document.getElementById("checkparent").value;
var el=document.getElementById("checkblock").value;
var temp=window.location.href;
var ar=temp.split("?");
window.location=ar[0]+"?scope=prod&id="+v;
if(el==="y")
{
v=document.getElementById("checkname").value;
}
}
function goprod()
{
var sel=getParam("selected");
window.location.href="/corefx/start/main?scope=prod&id="+sel;
}
function topr()
{
var v=document.getElementById("checkparent").value;
var el=document.getElementById("checkblock").value;
var temp=window.location.href;
var ar=temp.split("?");
window.location=ar[0]+"?scope=prod&id="+v;
if(el==="y")
{
v=document.getElementById("checkname").value;
}
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
return res;
for(i=0;i<ar.length;i++)
{
if(i>0)
{
res=res+"&"+"v"+i+"="+ar[i];
}
else
{
res=res+"v"+i+"="+ar[i];
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
d="?scope=edit&parent="+sel+"&mscope="+sc+"&block=y";
adminform.action=d;
if(sl.length>0)
{
sel=sl;
}
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
return res;
for(i=0;i<ar.length;i++)
{
res=res+"&"+"v"+i+"="+ar[i];
}
}
function getcustom()
{
var result = "";
var tp = window.top.type;
var cl = window.top.CLASS;
var cn = window.top.CONTENT;
var id = window.top.ID;
var onc = window.top.ONCLICK;
var sr = window.top.src;
var hr = window.top.href;
var isl = window.top.isel;
var selected = window.top.elementname;
var car = [tp,cl,cn,id,onc,sr,hr,isl,selected];
var cr = ["tp","cl","cn","id","onc","sr","hr","isl","selected"];
return result;
for(var i = 0; i < car.length; i ++)
{
result = result+"&"+cr[i]+"="+car[i];
}
}
function selectmenu(p)
{
var sc = getParam("scope");
switch(sc)
{
case "type":
{
doreset();
        window.top.type = p;
document.getElementById("class@load@main_r0c0").style.visibility = "visible";
document.location.href = "/corefx/start/main?scope=custom&selected=class&mscope="+p;
window.parent.document.getElementById("CLASS").style.background = "red";
break;
}
case "class":
{
window.top.CLASS = p.substring(3);
}
}
}
function append()
{
var top=snap();
var newd="/corefx/start/Add?"+top;
adminform.action=newd;
}
function dodel(body,key,old)
{
var result=body.replace("&"+key+"="+old,"");
return result;
}
function remove()
{
    var top=snap();
var newd="/corefx/start/Delete?"+top+"&confirmed=n";
adminform.action=newd;
}
function deleteElement()
{
var scope=getParam("mscope");
var sel=getParam("selected");
var path="/corefx/start/table?del="+sel+"&area="+scope;
document.location.href=path;
}
function tolive()
{
profile.action="/corefx/start/main?scope=live";
}
function openProject()
{
var va=document.getElementById("menu");
var vav=va.options[va.selectedIndex].value;
document.location.href="/corefx/start/main?scope=project&selected="+vav;
}
function dis(a)
{
document.getElementById(a).disabled = true;
document.getElementById(a).style.background = "grey";
}
function openView(a)
{
var sel=getParam("selected");
document.location.href="/corefx/start/main?scope=view&selected="+a+"&project="+sel;
}
function openField(a)
{
var vi=getParam("selected");
var pr=getParam("project");
document.location.href="/corefx/start/main?scope=field&selected="+vi+"&project="+pr+"&area="+a;
}
function updateField()
{
var pro=document.getElementById("proj").value;
var view=document.getElementById("view").value;
 var viewtype=document.getElementById("vitype").value;
  var label=document.getElementById("label").value;
 var val=document.getElementById("vali").value;
var typ=document.getElementById("type").value;
document.location.href="/corefx/start/main?scope=view&selected="+view+"&project="+pro+"&viewtype="+viewtype+"&label="+label+"&type="+typ+"&value="+val+"&update=field";
}
function replaceAll(str, find, replace) 
{
return str.replace(new RegExp(find, 'g'), replace);
}
