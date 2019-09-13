import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class YoutubeService {
  playlist = [
    {id: 'vOXZkm9p_zY', song: 'Imagine Dragons - Bird'},
    {id: 'kTJbE3sfvlI', song: 'Alan Walker - Lily'},
    {id: '-Ed-GNq2EyU', song: 'Alan Walker - Lost control'},
    {id: 'WXBHCQYxwr0', song: 'Ava Max - Sweet but Psycho'},
    {id: 'aatr_2MstrI', song: 'Clean Bandit - Symphony'},
    {id: 'cBVGlBWQzuc', song: 'Maroon 5 - Girls like you'},
    {id: 'Pkh8UtuejGw', song: 'Shawn Mendes, Camila Cabello - Señorita'},
    {id: 'aRjg6oSrY7U', song: 'Nàng Thơ Xứ Huế | Thùy Chi'}
  ];

  constructor() {
  }

  find(id: string) {
    return this.playlist.find(item => item.id === id);
  }
}
