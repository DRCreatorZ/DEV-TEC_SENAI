int segmentos[] = { 2, 3, 4, 5, 6, 7, 8, 9 };
int digitos[][8] = {
  { 1, 1, 1, 1, 1, 1, 0, 0 },  //0
  { 0, 1, 1, 0, 0, 0, 0, 0 },  //1
  { 1, 1, 0, 1, 1, 0, 1, 0 },  //2
  { 1, 1, 1, 1, 0, 0, 1, 0 },  //3
  { 0, 1, 1, 0, 0, 1, 1, 0 },  //4
  { 1, 0, 1, 1, 0, 1, 1, 0 },  //5
  { 1, 0, 1, 1, 1, 1, 1, 1 },  //6
  { 1, 1, 1, 0, 0, 0, 0, 0 },  //7
  { 1, 1, 1, 1, 1, 1, 1, 0 },  //8
  { 1, 1, 1, 1, 0, 1, 1, 0 },  //9
};
void setup() {
  //declarando todas as portas como output
  //portas definidas no vetor segmentos[]
  for (int i = 0; i <= 8; i++) {
    pinMode(segmentos[i], OUTPUT);
  }

  //declarar meu potenciometro
  pinMode(A0, INPUT);
  Serial.begin(9600);  //
}

void loop() {
  int potenciometro = analogRead(A0);
  int n = potenciometro / 102,4;  //transformando o  numero do potenciometro de 0-9
  Serial.println(A0);
  Serial.println(n);
  for (int i = 0; i < 8; i++) {
    digitalWrite(segmentos[i], digitos[n][i]);
  }
  delay(50);
}