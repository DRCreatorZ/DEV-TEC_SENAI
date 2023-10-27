import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Curriculo } from './model/curriculo.model';
@Injectable({
providedIn: 'root',
})
export class CurriculoService {
private apiUrl = 'assets/curriculos.json'; // Caminho para o arquivo JSON (pode ser ajustado)
constructor(private http: HttpClient) {}

getCurriculos() {
return this.http.get<Curriculo[]>(this.apiUrl);
}
adicionarCurriculo(curriculo: Curriculo) {
return this.getCurriculos()
.pipe()
.subscribe((curriculos) => {
curriculo.id = curriculos.length + 1; // Gere um novo ID
curriculos.push(curriculo);
this.salvarCurriculos(curriculos);
});
}
private salvarCurriculos(curriculos: Curriculo[]) {
this.http.put(this.apiUrl, curriculos).subscribe();
}
}