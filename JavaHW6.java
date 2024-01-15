//1. Создать класс Поток содержащий в себе список УчебныхГрупп и реализующий интерфейс Iterable.
//2. Создать класс StreamComparator, реализующий сравнение количества групп входящих в Поток.
//3. Создать класс ПотокСервис, добавив в него метод сортировки списка потоков, используя созданный StreamComparator.
//4. Модифицировать класс Контроллер, добавив в него созданный сервис.

import java.util. \* ;

public class Stream implements Iterable<Group> {
    private List<Group> groups;

    public Stream(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public Iterator<Group> iterator() {
        return groups.iterator();
    }

    public static Comparator<Stream> comparator = new StreamComparator();

    public static void main(String[] args) {
        List<Group> groups = new ArrayList<>();
        // Здесь вы можете добавить группы в список

        Stream stream = new Stream(groups);
        Collections.sort(stream, StreamComparator.comparator);
    }
}

public class StreamComparator implements Comparator<Stream> {
    @Override
    public int compare(Stream stream1, Stream stream2) {
        return stream1.groups.size() - stream2.groups.size();
    }
}

public class StreamService {
    public static void sortStreams(List<Stream> streams) {
        Collections.sort(streams, StreamComparator.comparator);
    }
}

public class Controller {
    private StreamService streamService;

    public Controller() {
        streamService = new StreamService();
    }

    public void sortStreams() {
        List<Stream> streams = new ArrayList<>();
        // Здесь вы можете добавить потоки в список

        streamService.sortStreams(streams);
    }
}

