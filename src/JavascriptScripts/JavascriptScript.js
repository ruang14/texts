/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function test() {
    print("bait\n");
    var d = new Date().getFullYear() + 1;
//    var y = d.getFullYear();
//    print(y + "\n");
    print(d + "\n");
    var startDate = "2020/01/01";
    var date = d;
    
    print("startdate: " + startDate + "\n");
    print("date: " + date + "\n");
    
    if(Date.parse(startDate) < Date.parse(d + "/12/31")){
        print("true" + "\n");
    } else {
        print("false" + "\n");
    }
}