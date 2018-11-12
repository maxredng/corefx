var color;
var ob;
var tid="1510299393097@main@_r0c0";

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
}
function dragIt(ev) {
    ev.dataTransfer.setData("text", ev.target.getAttribute('id'));
}


function drop(ev) {
    ev.preventDefault();

            
            var trg = ev.target.getAttribute("newtarget");
            var id = ev.dataTransfer.getData("text");

  
    if(trg)
    {
        if(trg!=='true')
        {
            var ch = ev.target.innerHTML;
          
            ev.target.innerHTML = ev.target.innerHTML + getMyElement();

            
        }else
        {
 
        }
        
    }else
    {
        
            if(id!=='row')
    {
     
                            var data = ev.dataTransfer.getData("text");
                            ev.target.appendChild(document.getElementById(data)); 
    }else
    {
       var ch = ev.target.innerHTML;
      
       ev.target.innerHTML = ev.target.innerHTML + getMyElement();

   }

    }

      
       var obs = document.getElementById(tid).getElementsByTagName("div");
    //   document.getElementById(tid).innerHTML = "";
       for(var i = 0;i<obs.length; i ++)
       {
           obs[i].style.position = "relative";
           obs[i].style.top = "";

     //        document.getElementById(tid).innerHTML = document.getElementById(tid).innerHTML + obs[i].outerHTML;

       }
    
    }


function von(ev)
{
    
     
     var y = ev.target.getBoundingClientRect().top;
    
    ob = "1000px";
    ev.target.style.position = "absolute";
    ev.target.style.width = ob;
    //ev.target.style.background = "black";
    document.getElementById(ev.target.id).style.top = y+ 120 + "px";
    
 //   document.getElementById(ev.target.id).innerHTML = document.getElementById(ev.target.id).style.top;   
    
    
}


function whenOn(ev)
{
    
    var y = ev.target.getBoundingClientRect().top;
    
    var cont = document.getElementById(tid);
    var content = cont.getElementsByTagName("div");
    
    for(var i = 0; i<content.length; i++)
    {
        var el = content[i];
        
        var yl = el.getBoundingClientRect().top;
        
        if(yl > y - 50)
        {
        el.style.position = "absolute";
        el.style.width = "1000px";
        el.style.top = yl + 100 + "px";
      
        
        }
        
    }
    

  // von(ev);

    
    
}

// <div class="border" id="1510299393097@main@_r0c0" style="width: 1000px; height: 600px;" ondragover="allowDrop(event)" ondrop="drop(event)">
function createID()
{
    var date = new Date();
    var result = date.getTime();
    
    return " ";
}
function getMyElement()
{
    var id = createID();
    return "<div style='width:100%;height:100px;background:" + getColor() + ";resizable:both' class='borderelement' newtarget='true' id='" + id + "' ondragstart='dragIt(event)' ondragover='whenOn(event)' draggable='true'/>";
      //      +id+"</div>";
}



//function getElement(a)
//{
//    return "<div style='width:100%;height:100px;background:" + getColor() + ";resizable:both' class='borderelement' newtarget='true' id='" + a + "' ondragstart='dragIt(event)' ondragover='whenOn(event)' draggable='true'>"+a+"</div>";
//}

function getColor()
{
    if(color)
    {
  //      alert(color);
        if(color === "coral")
        {
            color = "lightblue";
            return color;
        }else
        {   color = "coral";
            return color;
        }
        
    }else
    {
        color = "coral";
        return color;
    }
    
    
}