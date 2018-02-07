int etat = 0;   // for incoming serial data

void setup() {
        Serial.begin(9600);     // opens serial port, sets data rate to 9600 bps
        pinMode(4, OUTPUT);    

}

void loop() {

        // send data only when you receive data:
        if (Serial.available() > 0) {
                etat = Serial.read();

                // say what you got:
                Serial.print("I received: ");
                Serial.println(etat, DEC);
                if (etat == 1){
                  digitalWrite(4, HIGH);   
                }
                else{
                  digitalWrite(4, LOW);   
                } 
         }
}

/*void setup() {                
  pinMode(4, OUTPUT);    
}

void loop() {
  digitalWrite(4, HIGH);   
  delay(1000);              
  digitalWrite(4, LOW);    
  delay(1000);              
}*/

