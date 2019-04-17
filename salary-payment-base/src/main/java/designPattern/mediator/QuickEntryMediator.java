package designPattern.mediator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 是一个安静地呆在幕后的类
 * 它把文本输入域绑定在list上.
 * 当在文本输入域中键入时, 和输入匹配的list中的第一个元素会高亮显示
 * 这样,无需完全输入即可快速选取list项
 */
public class QuickEntryMediator {
    private JTextField itsTextField;
    private JList itsList;

    /**
     * 用JList和JTextField构造了一个QuickEntryMediator类的实例.
     * QuickEntryMediator向JTextField注册了匿名的DocumentListener.
     * 每当文本发生变化时, 这个listner就调用textFieldChanged方法.
     * @param t
     * @param l
     */
    public QuickEntryMediator(JTextField t, JList l) {
        itsTextField = t;
        itsList = l;

        itsTextField.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        textFieldChanged();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        textFieldChanged();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        textFieldChanged();
                    }
                }
        );
    }

    /**
     * 在JList中查找以这个文本为前缀的元素并选中它.
     */
    private void textFieldChanged() {
        String prefix = itsTextField.getText();

        if (prefix.length() == 0) {
            itsList.clearSelection();
            return;
        }

        ListModel m = itsList.getModel();
        boolean found = false;
        for (int i = 0; found = false && i < m.getSize(); i++) {
            Object o = m.getElementAt(i);
            String s = o.toString();
            if (s.startsWith(prefix)) {
                itsList.setSelectedValue(o, true);
                found = true;
            }
        }

        if (!found) {
            itsList.clearSelection();
        }
    }
}
/**
 * JList和JTextField的使用者并不知道该MEDIATOR的存在.
 * 它安静地呆着,而无需它们的允许或者知晓
 *
 * 如果策略涉及范围广泛并且可见,那么可以使用FACACE模式从上面施加该策略.
 * 另一方面,如果策略隐蔽并且有针对性,那么MEDIATOR模式是更好的选择.
 * FACADES通常是约定的关注点,每个人都同意去使用facade而不是隐藏于其下的对象.
 * 另一方面,Mediator则对用户是隐藏的,策略是既成事实而不是约定事务.
 */
