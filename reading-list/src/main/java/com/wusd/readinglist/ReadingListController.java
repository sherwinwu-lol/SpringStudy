package com.wusd.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Controller: 将其注册为Spring上下文的Bean
 * @RequestMapping: 将处理器方法都映射到"/"这个URL路径上.
 * @ConfigurationProperties: 属性注入
 */
@Controller
@RequestMapping("/")
public class ReadingListController {
    private ReadingListRepository readingListRepository;
    private AmazonProperties amazonProperties;

    /**
     * @param readingListRepository
     * @param amazonProperties: 注入AmazonProperties
     */
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, AmazonProperties amazonProperties) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
    }

    /**
     * 根据路径指定的读者, 从仓库获取Book列表.
     * @param reader
     * @param model
     * @return 视图逻辑名称
     */
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader,
                               Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            // 将associateId放入模板
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    /**
     * 将正文的数据绑定到一个Book对象上.
     * @param reader
     * @param book
     * @return
     */
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        // 重定向到/{reader}
        return "redirect:/{reader}";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Book book, String reader) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList";
    }

    /**
     * 配置属性在调优方面十分有用, 这里说的调优不仅覆盖了自动配置的组件, 还包括注入自有应用程序Bean的细节.
     */
}
