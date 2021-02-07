import { faculty } from "./faculty";
import { schedule } from "./schedule";
import { subject } from "./subject";

export class ProcessedSchedule{
    faculty: faculty = new faculty;
    schedule: schedule = new schedule;
    subject: subject = new subject;
}