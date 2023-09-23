package BehavioralPatterns;
//Позволяет избежать жесткой зависимости отправителя запроса от его получателя, при этом запрос может быть обработан несколькими объектами.

public class ChainOfResponsibility {
    public static void main(String[] args) {
        RequestHandler lowPriorityHandler = new LowPriorityHandler();
        RequestHandler mediumPriorityHandler = new MediumPriorityHandler();
        RequestHandler highPriorityHandler = new HighPriorityHandler();

        lowPriorityHandler.setNextHandler(mediumPriorityHandler);
        mediumPriorityHandler.setNextHandler(highPriorityHandler);

        Request request1 = new Request(Priority.LOW);
        Request request2 = new Request(Priority.MEDIUM);
        Request request3 = new Request(Priority.HIGH);

        lowPriorityHandler.handleRequest(request1);
        lowPriorityHandler.handleRequest(request2);
        lowPriorityHandler.handleRequest(request3);
        System.out.println();
        mediumPriorityHandler.handleRequest(request1);
        mediumPriorityHandler.handleRequest(request2);
        mediumPriorityHandler.handleRequest(request3);
        System.out.println();
        highPriorityHandler.handleRequest(request1);
        highPriorityHandler.handleRequest(request2);
        highPriorityHandler.handleRequest(request3);
    }
}

abstract class RequestHandler {
    private RequestHandler nextHandler;

    public void setNextHandler(RequestHandler handler) {
        nextHandler = handler;
    }

    public void handleRequest(Request request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

enum Priority {
    LOW, MEDIUM, HIGH
}

class Request {
    private Priority priority;

    public Request(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}

class LowPriorityHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.LOW) {
            System.out.println("Request handled with low priority.");
        } else {
            super.handleRequest(request);
        }
    }
}

class MediumPriorityHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.MEDIUM) {
            System.out.println("Request handled with medium priority.");
        } else {
            super.handleRequest(request);
        }
    }
}

class HighPriorityHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.HIGH) {
            System.out.println("Request handled with high priority.");
        } else {
            super.handleRequest(request);
        }
    }
}