/*
 * Java Bittorrent API as its name indicates is a JAVA API that implements the Bittorrent Protocol
 * This project contains two packages:
 * 1. jBittorrentAPI is the "client" part, i.e. it implements all classes needed to publish
 *    files, share them and download them.
 *    This package also contains example classes on how a developer could create new applications.
 * 2. trackerBT is the "tracker" part, i.e. it implements a all classes needed to run
 *    a Bittorrent tracker that coordinates peers exchanges. *
 *
 * Copyright (C) 2007 Baptiste Dubuis, Artificial Intelligence Laboratory, EPFL
 *
 * This file is part of jbittorrentapi-v1.0.zip
 *
 * Java Bittorrent API is free software and a free user study set-up;
 * you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Java Bittorrent API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Java Bittorrent API; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * @version 1.0
 * @author Baptiste Dubuis
 * To contact the author:
 * email: baptiste.dubuis@gmail.com
 *
 * More information about Java Bittorrent API:
 *    http://sourceforge.net/projects/bitext/
 */

package jBittorrentAPI;

import java.lang.ArrayIndexOutOfBoundsException;
import java.io.InputStream;
import java.io.IOException;

/**
 * Constants used in Peer Protocol.
 *
 * @author Baptiste Dubuis
 * @version 0.1
 */
public class PeerProtocol {
    public static final int HANDSHAKE = -1;
    public static final int KEEP_ALIVE = 0;
    public static final int CHOKE = 1;
    public static final int UNCHOKE = 2;
    public static final int INTERESTED = 3;
    public static final int NOT_INTERESTED = 4;
    public static final int HAVE = 5;
    public static final int BITFIELD = 6;
    public static final int REQUEST = 7;
    public static final int PIECE = 8;
    public static final int CANCEL = 9;
    public static final int PORT = 10;
    public static final String[] TYPE = {"Keep_Alive", "Choke", "Unchoke",
                                        "Interested", "Not_Interested", "Have",
                                        "Bitfield", "Request", "Piece",
                                        "Cancel", "Port"};

    public static final int BLOCK_SIZE = 16384;
    public static final byte[] BLOCK_SIZE_BYTES = Utils.intToByteArray(16384);

}
