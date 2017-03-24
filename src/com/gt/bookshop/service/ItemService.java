package com.gt.bookshop.service;

import com.gt.bookshop.entities.Item;
import com.sun.net.httpserver.HttpContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GongTao on 2017/2/12/012.
 * ���������� ���ﳵ��ҵ����
 */
@Service
public class ItemService {

    /**
     * ֻ�����ԣ���session�� car ��ù��ﳵ���� Items
     */
    private List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * �ڹ��ﳵ�� ��ѯ���Ϊid�Ĺ�����
     * @param id  ���Ϊid�Ĺ�����
     * @return  ���ڣ����������������ڷ���-1
     */
    private int search(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * ��ӹ�������ﳵ��
     * ������ﳵ��û�й���������ӣ�������ڣ����������ۼ�
     * @param item  ������
     */
    public void add(Item item) {
        int ret = search(item.getId());//�Ȳ�
        if (ret == -1)
        {
            items.add(item);
        }
        else {
            items.get(ret).setQty(items.get(ret).getQty()+1);
        }
    }

    /**
     * �ڹ��ﳵ���޸ı��Ϊid�Ĺ����ֻ�޸�����qty
     * @param id  ���޸ĵĹ�������
     * @param qty Ҫ�޸ĵĹ�������
     */
    public void update(int id, int qty) {
        int ret = search(id);//�Ȳ�
        if (ret != -1) {
            //������ڣ����޸Ķ�Ӧ������
            items.get(ret).setQty(qty);
        }
    }

    /**
     * �ڹ��ﳵ��ɾ�����Ϊid�Ĺ�����
     * @param id  Ҫɾ���ı��
     */
    public void delete(int id) {
        int ret = search(id);//�Ȳ�
        if (ret != -1)
        {
            //������ڣ���ɾ��ָ������λ�õĶ���
            items.remove(ret);
        }
    }

    /**
     * ������ﳵ
     */
    public void removeAll() {
        items.clear();//�����������

    }

    /**
     * ��������ǽ���ǰ���ﳵ�����ݱ�����cookie��
     * cookieӦ��ʹ�ö�ֵ
     * key���id��value�������
     */
    public void saveCarToCookie() {

    }

    /**
     * ��cookie��ȡ�����ﳵ��Ϣ�����ؽ�session
     * ������Ӧ����ʲôʱ����ã�session_start�����
     */
    public void loadCarFromCookie() {

    }
}
