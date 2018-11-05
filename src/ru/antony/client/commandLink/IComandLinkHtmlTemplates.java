package ru.antony.client.commandLink;

import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeUri;

//This interface is not used here anymore but I left for a history and for a case I need to get some sample code.

public interface IComandLinkHtmlTemplates extends SafeHtmlTemplates {

    @Template("<span style='margin: 0px 4px; font-family: Arial, Helvetica, sans-serif; font-size: 10pt;'>{0}<span/>")
    SafeHtml getText(String text);

    @Template("<img src='{0}'/>")
    SafeHtml getImageNoMargin(SafeUri imageUri);

    @Template("<img src='{0}' style='margin: 0px 4px;'/>")
    SafeHtml getImageWithMargin(SafeUri imageUri);

    @Template("<div style='display: flex; align-items: center; justify-content: center; flex-wrap: wrap;'>")
    SafeHtml getBeginHtml();

    @Template("</div>")
    SafeHtml getEndHtml();

    @Template("{0}{1}{2}")
    SafeHtml getOneElementHtml(SafeHtml beginHtml, SafeHtml el1Html, SafeHtml endHtml);

    @Template("{0}{1}{2}{3}")
    SafeHtml getTwoElementsHtml(SafeHtml beginHtml, SafeHtml el1Html, SafeHtml el2Html, SafeHtml endHtml);

    @Template("{0}{1}{2}{3}{4}")
    SafeHtml getThreeElementsHtml(SafeHtml beginHtml, SafeHtml el1Html, SafeHtml el2Html, SafeHtml el3Html, SafeHtml endHtml);

    @Template("{0}{1}{2}{3}{4}{5}")
    SafeHtml getFourElementsHtml(SafeHtml beginHtml, SafeHtml el1Html, SafeHtml el2Html, SafeHtml el3Html, SafeHtml el4Html, SafeHtml endHtml);

}
