package de.thomasjacob.hypertunnel.client.delegate;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * @author thomas
 */
public class ClipboardSyncDelegate extends Delegate implements ClipboardOwner {

	public static final String CATEGORY = "clipboard";

	@Override
	public void execute(String sourceClient, byte[] payload) {
		String payloadString = decodePayload(payload);
		System.out.println("Setting clipboard to '" + payloadString + "'");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(payloadString), this);
	}

	@Override
	public String getCategory() {
		return CATEGORY;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// Do nothing
	}
}
