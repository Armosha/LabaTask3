package nb.command.impl;

import nb.bean.FindByDateRequest;
import nb.bean.FindByDateResponse;
import nb.bean.Request;
import nb.bean.Response;
import nb.command.Command;
import nb.command.exception.CommandException;

/**
 * Created by Iryna Filipava on 06.10.2016.
 */
public class FindByDate implements Command {

    public FindByDate() {

    }

    @Override
    public Response execute(Request request) throws CommandException {

        Response response = new FindByDateResponse();
        FindByDateResponse res;
        FindByDateRequest req;
        int day = 0;
        int month = 0;
        int year = 0;

        if (response instanceof FindByDateResponse) {
            res = (FindByDateResponse) response;
        } else {
            throw new CommandException("Wrong response");
        }

        if (request instanceof FindByDateRequest) {
            req = (FindByDateRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }
        try {
            if (req.getDay() != null && !req.getDay().equals(" ")) {
                day = Integer.parseInt(req.getDay());
            }
            if (req.getMonth() != null && !req.getMonth().equals(" ")) {
                month = Integer.parseInt(req.getMonth());
            }
            if (req.getYear() != null && !req.getYear().equals(" ")) {
                year = Integer.parseInt(req.getYear());
            }
        } catch (NumberFormatException e) {
            throw new CommandException("Wrong date");
        }

        CurrentTime timelist = new CurrentTime(day, month, year);

        res.setErrorStatus(true);
        if (timelist.getCurrentDate().isEmpty()) {
            res.setResultMessage("There isn't notes!");
        } else {
            res.setDateNotes(timelist.getCurrentDate());
            res.setResultMessage("All OK!");
        }

        return res;
    }
}