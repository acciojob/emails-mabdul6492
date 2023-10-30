package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        if(calendar.isEmpty()) return 0;

        calendar.sort((a, b) -> {
            if(a.getStartTime().equals(b.getStartTime())) return a.getEndTime().compareTo(b.getEndTime());
            return a.getStartTime().compareTo(b.getStartTime());
        });

        int count = 1;
        LocalTime end = calendar.get(0).getEndTime();
        for(Meeting meeting: calendar){
            if(meeting.getStartTime().isAfter(end)){
                count++;
                end = meeting.getEndTime();
            }
        }

        return count;
    }
}
