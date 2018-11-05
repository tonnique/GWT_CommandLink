package ru.antony.client.commandLink;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.SimpleHtmlSanitizer;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.Widget;


public class CommandLink extends Composite implements HasText {
	/**
	 * UiBinder template code
	 */
    private static CommandLinkUiBinder uiBinder = GWT.create(CommandLinkUiBinder.class);
    interface CommandLinkUiBinder extends UiBinder<Widget, CommandLink> {}

    private final static String COMMAND_LINK_IMAGE = "tarantino.png";     
    private static final Images COMMAND_LINK_IMAGES = GWT.create(Images.class);
    
	//private final static IComandLinkHtmlTemplates HTML_TEMPLATE = GWT.create(IComandLinkHtmlTemplates.class);
		
	private String oldBackgroundColor;
	
	@UiField
	FocusPanel commandLinkHolder;
	@UiField
	Label commandLinkCaptionLabel;
	@UiField
	Label descriptionLabel;
	@UiField
	Image commandLinkImage;
	@UiField
	Label commandLinkFaImage;

	private boolean faImageIsSet = false;	

	public CommandLink() {		
		initWidget(uiBinder.createAndBindUi(this));
		setDefaultImage();
		setEventHandlersForCommandLinkHolder();		
		commandLinkFaImage.setVisible(false);
	}
	
	public void setCaption(String caption) {
		commandLinkCaptionLabel.setText(caption);
	}
	
	public void setText(String text) {		
		descriptionLabel.setText(text);		
	}

	@Override
	public String getText() {		
		return descriptionLabel.getText();		
	}
		
	public void setDescription(String text) {
		if (text == null || text.isEmpty()) {
			return;
		}
		descriptionLabel.setText(text);		
	}
	
	public void setSrc(String imageSource) {
		if (imageSource == null || imageSource.isEmpty() || faImageIsSet) {			
			return;
		}		
		switchImageForFarImage();
		commandLinkImage.setUrl(UriUtils.fromString(imageSource));		
	}
	
	public void setFaImageClass(String faImageClass) {
		if (faImageClass == null || faImageClass.isEmpty()) {					
			return;
		}
		faImageIsSet = true;		
		switchImageForFarImage();		
		commandLinkFaImage.getElement().setInnerHTML("<i class=\"" + faImageClass + "\"></i>");		
	}	
	
	private void switchImageForFarImage() {
		commandLinkImage.setVisible(!faImageIsSet);
		commandLinkFaImage.setVisible(faImageIsSet);
	}
	
	private void setDefaultImage() {
		commandLinkImage.setResource(COMMAND_LINK_IMAGES.image());
	}
	
	private void setEventHandlersForCommandLinkHolder() {
		commandLinkHolder.addMouseOverHandler(new MouseOverHandler(){
			   public void onMouseOver(MouseOverEvent event){
				   oldBackgroundColor = commandLinkHolder.getElement().getStyle().getBackgroundColor();
				   commandLinkHolder.getElement().getStyle().setBackgroundColor("lightblue");
		   }
		});
		
		// Add a mouse out handler to restore the background color of the widget once the mouse leaves it.
		commandLinkHolder.addMouseOutHandler(new MouseOutHandler(){
			   public void onMouseOut(MouseOutEvent event){
				   commandLinkHolder.getElement().getStyle().setBackgroundColor(oldBackgroundColor);
			   }
			}
		);		
	}
	
	interface Images extends ClientBundle {
        @Source(COMMAND_LINK_IMAGE)
        ImageResource image();
    }	

}
