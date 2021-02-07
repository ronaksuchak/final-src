import { coordinator } from './coordinator';
import { notice } from './notice';
import { faculty } from './faculty';
export class processedNotice {
        faculty = new faculty();
        notice = new notice();
        coordinator = new coordinator();
}
